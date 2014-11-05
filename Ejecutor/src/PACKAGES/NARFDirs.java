package PACKAGES;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NARFDirs {//All the directories and files needed for the software to work. Files must always end with /

    public static final String home = System.getProperty("user.home");
    public static final String strats = home + "/narf/executor/strategies/";
    public static final String scripts = home + "/narf/executor/rman_scripts/";
    public static final String local_logs = home + "/narf/executor/local_logs/logs/";
    public static final String local_outputs = home + "/narf/executor/local_logs/outputs/";
    public static final String backups = home + "/narf/executor/backup_files/";
    public static final String configFile = home + "/narf/executor/config";

    /*MOTHERSHIP (The instance running Constructor)*/
    public static String motherDBLink = "luisk";
    public static String motherUser = "luisk";
    public static String motherIP = "127.0.0.1";
    public static String motherLogs = "~/narf/revisor/logs/";//never changes
     public static String motherOutputs = "~/narf/revisor/outputs/";//never changes

    /*MY DB*/
    public static String dbusername = "sys as sysdba";
    public static String dbpassword = "root";
    public static String dbport = "1521";
    public static String dbInstance = "XE";

    public static void setParameters() {
        File configFile = new File(NARFDirs.configFile);
        String mUser = null;
        String mIP = null;
        try {
            //LIST OF ALL CONFIG LINES.
            ArrayList<String> configLines = (ArrayList<String>) Files.lines(configFile.toPath()).collect(Collectors.toList()); //In case I need any more parameters
            //Reading First line: Mother parameters
            NARFDirs.setMotherShipParameters(configLines.get(0));
            //Reading Second line, Database parameters
            NARFDirs.setDBParameters(configLines.get(1));

        } catch (IOException ex) {
            System.err.println("CONFIG FILE FAILURE.");
            Logger.getLogger(NARFDirs.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (motherUser != null && mIP != null) {
            NARFDirs.motherUser = mUser;
            NARFDirs.motherIP = mIP;
        }

    }    
    
    private static void setMotherShipParameters(String msParamLine) {
        String[] motherParameters = null;
        if (msParamLine != null && !msParamLine.isEmpty()) {
            motherParameters = msParamLine.split("\\t");
        }
         /*
             MOTHERLODE
             [0] database link
             [1] IP
             [2] Linux Username
             */
        if (motherParameters != null && motherParameters.length == 3) {
            motherDBLink = motherParameters[0];
            motherIP = motherParameters[1];
            motherUser = motherParameters[2];
        } else {
            System.err.println("COULD NOT SET MOTHER PARAMETERS, USING DEFAULT");
        }
    }

    private static void setDBParameters(String dbParamLine) {
        String[] myDBParameters = null;
        if (dbParamLine != null && !dbParamLine.isEmpty()) {
            myDBParameters = dbParamLine.split("\\t");
        }
        /*
         Database parameters
         [0] username
         [1] password
         [2] port
         [3] Instance
         */
        if (myDBParameters != null && myDBParameters.length == 4) {
            dbusername = myDBParameters[0];
            dbpassword = myDBParameters[1];
            dbport = myDBParameters[2];
            dbInstance = myDBParameters[3];
        }
    }

}
