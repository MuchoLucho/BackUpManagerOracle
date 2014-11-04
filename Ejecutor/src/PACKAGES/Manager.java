package PACKAGES;

import it.sauronsoftware.cron4j.Predictor;
import it.sauronsoftware.cron4j.Scheduler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Manager {

    public static boolean finished = false;

    private static void oldMain() {
        // Creates a Scheduler instance.
        Scheduler s = new Scheduler();
        // Schedule a once-a-minute task.
        //Predictor p = new Predictor("0 5-4/4 * * *");
        //IntStream.rangeClosed(0,5).forEach((i)->{System.out.println(Integer.toString(i)+" "+p.nextMatchingDate().toString());});
        s.schedule("* * * * *", () -> System.out.println("Another minute has passed"));
        List<Strategy> listStrat = new ArrayList<>();
        Runnable thr = () -> {
            while (!finished) {
                try {
                    System.out.println("-->Thread: checking for new files...");
                    FolderChecker.listenFolder();
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.err.println("THE THREAD HAS EXITED");

        };
        Thread t = new Thread(thr);
        t.start();
        //s.setDaemon(true);
        // Starts the scheduler.
        s.start();
        JOptionPane.showMessageDialog(null, "Desea cerrarlo?");
        s.stop();
        finished = true;

    }

    public static void startFolderListenerThread() {
        Runnable thr = () -> {
            while (!finished) {
                try {
                    System.out.println("-->Thread: checking for new files...");
                    FolderChecker.listenFolder();
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.err.println("THE THREAD HAS EXITED");
            StrategyScheduler.stopScheduler();

        };
        Thread t = new Thread(thr);
        t.start();
    }

    private static JTextArea testTextArea() {
        JFrame frame = new JFrame("executor");
        JPanel mainPanel = new JPanel();
        JScrollPane scrollpanel = new JScrollPane();
        JTextArea textArea = new JTextArea("swaag");
        textArea.setEditable(false);
        mainPanel.add(textArea);
        scrollpanel.add(mainPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        return textArea;
    }

    public static void main(String[] args) {
        NARFDirs.setParameters();
        boolean schedStarted = StrategyScheduler.startScheduler();
        if (schedStarted) {
            System.err.println("Scheduler succesfully initialized");
            startFolderListenerThread();
        } else {
            System.err.println("FATAL: The scheduler did not start");
        }

        String input="";
        while (!finished) {
            input = JOptionPane.showInputDialog("EXECUTOR is running. Type exit to terminate it. ");
            finished = input.toLowerCase().equals("exit");
        }
        finished = true;
    }
}
