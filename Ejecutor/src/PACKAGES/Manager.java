package PACKAGES;

import it.sauronsoftware.cron4j.Predictor;
import it.sauronsoftware.cron4j.Scheduler;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;
public class Manager {
    public static boolean finished = false;
    public static void main(String[] args) {
         // Creates a Scheduler instance.
        Scheduler s = new Scheduler();
        // Schedule a once-a-minute task.
        //Predictor p = new Predictor("0 5-4/4 * * *");
        //IntStream.rangeClosed(0,5).forEach((i)->{System.out.println(Integer.toString(i)+" "+p.nextMatchingDate().toString());});
        s.schedule("* * * * *", ()->System.out.println("Another minute has passed"));
        List<Strategy> listStrat = new ArrayList<>();
        Runnable thr = ()->{
            while(!finished){
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
}
