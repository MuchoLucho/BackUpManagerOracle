package PACKAGES;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Parameters {//All the directories and files needed for the software to work. Files must always end with /

    public static final String home = System.getProperty("user.home");
    public static final String configFile = home + "/narf/controller/config";
    public static final String dbparams = home + "/narf/controller/dbparams";

    /*MY DB*/
    public static String dbusername = "sys as sysdba";
    public static String dbpassword = "root";
    public static String dbport = "1521";
    public static String dbInstance = "XE";
    /*
     Database parameters
     [0] username
     [1] password
     [2] port
     [3] Instance
    */
    public static void configureDB() {
        File configFile = new File(Parameters.dbparams);
        String[] dbparams=null;
        try {
            //LIST OF ALL CONFIG LINES.
            ArrayList<String> configLines = (ArrayList<String>) Files.lines(configFile.toPath()).collect(Collectors.toList()); //In case I need any more parameters
            //Reading First line: Mother parameters
            if (configLines != null) {
                dbparams = configLines.stream().findFirst().get().split("\\t");
            }
            if(dbparams!=null){
                dbusername = dbparams[0];
                dbpassword = dbparams[1];
                dbport = dbparams[2];
                dbInstance = dbparams[3];
                
            }
        } catch (IOException ex) {
            System.err.println("CONFIG FILE FAILURE.");
            Logger.getLogger(Parameters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void configureNodes() {
        File configFile = new File(Parameters.configFile);
        try {
            //LIST OF ALL CONFIG LINES.
            ArrayList<String> configLines = (ArrayList<String>) Files.lines(configFile.toPath()).collect(Collectors.toList()); //In case I need any more parameters
            //Reading First line: Mother parameters
            if (configLines != null) {
                configLines.stream().forEach((line) -> {
                    Parameters.getNodeParameters(line);
                });
            }

        } catch (IOException ex) {
            System.err.println("CONFIG FILE FAILURE.");
            Logger.getLogger(Parameters.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void getNodeParameters(String msParamLine) {
        String[] motherParameters = null;
        String link;
        String linux;
        String IP;
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
            link = motherParameters[0];
            IP = motherParameters[1];
            linux = motherParameters[2];
            DB dbInfo = DBManager.getDbs().get(link);
            if (dbInfo != null) {
                dbInfo.setIP(IP);
                dbInfo.setLinux_user(linux);
            }
        } else {
            System.err.println("COULD NOT SET MOTHER PARAMETERS, USING DEFAULT");
        }
    }
}
