package PACKAGES;

import it.sauronsoftware.cron4j.Predictor;
import it.sauronsoftware.cron4j.SchedulerListener;
import it.sauronsoftware.cron4j.TaskExecutor;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogsGenerator {

    //private static String NARFDirs.logs = System.getProperty("user.home") + "/narf/executor/logs/";
    private static String extension = ".txt";

    public static String generateSampleLog(boolean success, Date date, Strategy str) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
        Predictor predictor = new Predictor(str.getCronString());
        String filename = str.getName() + "_" + dateformat.format(date)+extension;
        String fullDirectory = new StringBuilder(NARFDirs.logs).append(filename).toString();
        File f = new File(fullDirectory);
        //f.mkdirs();
        try {
            PrintWriter writer = new PrintWriter(f);
            writer.println("--------SAMPLE LOG FOR STRATEGY " + str.getName() + "--------");
            writer.println("Date: " + date.toString());
            writer.println("Rman command: " + str.getRmanString());
            writer.println("The strategy was " + ((success) ? "" : "un") + "successful");
            writer.println("Next 3 executions scheduled: ");
            writer.println(predictor.nextMatchingDate().toString());
            writer.println(predictor.nextMatchingDate().toString());
            writer.println(predictor.nextMatchingDate().toString());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LogsGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fullDirectory;
    }

    public static String generateLog(boolean success, Date date, Strategy str) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
        SimpleDateFormat onlyHour = new SimpleDateFormat("hh:mm");
        SimpleDateFormat onlyDate = new SimpleDateFormat("dd/mm/yyyy");
        Predictor predictor = new Predictor(str.getCronString());
        String filename = str.getName() + "_" + dateformat.format(date)+extension;
        String fullDirectory = new StringBuilder(NARFDirs.logs).append(filename).toString();
        File f = new File(fullDirectory);
        //f.mkdirs();
        try {
            PrintWriter writer = new PrintWriter(f);
            writer.print(str.getName() + "\t");
            writer.print((NARFDirs.dbInstance)+"\t");
            writer.print(onlyDate.format(date) + "\t");
            writer.print(onlyHour.format(date) + "\t");
            writer.print((success) ? "true" : "false");
            writer.print("\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LogsGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filename;
    }

    public static String getLogDirectory() {
        return NARFDirs.logs;
    }

    public static SchedulerListener generateListener() {
        SchedulerListener listener = new SchedulerListener() {

            @Override
            public void taskLaunching(TaskExecutor executor) {
            }

            @Override
            public void taskSucceeded(TaskExecutor executor) {
            }

            @Override
            public void taskFailed(TaskExecutor executor, Throwable exception) {
                System.err.println("************ERROR. A TASK FAILED AND THREW AN EXCEPTION************");
            }
        };
        return listener;
    }
}
