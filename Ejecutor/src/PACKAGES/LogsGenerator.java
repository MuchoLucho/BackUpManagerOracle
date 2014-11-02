package PACKAGES;

import it.sauronsoftware.cron4j.Predictor;
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

    private static String logDirectory = "C:/narf_executor/logs/";
    private static String extension = ".txt";
    public static String generateSampleLog(boolean success, Date date, Strategy str) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
        Predictor predictor = new Predictor(str.getCronString());
        String filename = str.getName()+"_"+dateformat.format(date);
        String fullDirectory = new StringBuilder(logDirectory).append(filename).append(extension).toString();
        File f = new File(fullDirectory);
        //f.mkdirs();
        try {
            PrintWriter writer = new PrintWriter(f);
            writer.println("--------SAMPLE LOG FOR STRATEGY "+str.getName()+"--------");
            writer.println("Date: " + date.toString() );
            writer.println("Rman command: "+str.getRmanString());
            writer.println("The strategy was " + ((success)?"":"un") + "successful");
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

    public static void setLogDirectory(String newDir) {
        LogsGenerator.logDirectory = newDir;
    }
}
