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
    
    public static void configureNodes() {
        File configFile = new File(Parameters.configFile);
        String mUser = null;
        String mIP = null;
        try {
            //LIST OF ALL CONFIG LINES.
            ArrayList<String> configLines = (ArrayList<String>) Files.lines(configFile.toPath()).collect(Collectors.toList()); //In case I need any more parameters
            //Reading First line: Mother parameters
            if(configLines!=null){
                configLines.stream().forEach((line)->{
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
        String link = null;
        String linux = null;
        String IP = null;
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
            dbInfo.setIP(IP);
            dbInfo.setLinux_user(linux);
            
        } else {
            System.err.println("COULD NOT SET MOTHER PARAMETERS, USING DEFAULT");
        }
    }

//    private static void setDBParameters(String dbParamLine) {
//        String[] myDBParameters = null;
//        if (dbParamLine != null && !dbParamLine.isEmpty()) {
//            myDBParameters = dbParamLine.split("\\t");
//        }
//        /*
//         Database parameters
//         [0] username
//         [1] password
//         [2] port
//         [3] Instance
//         */
//        if (myDBParameters != null && myDBParameters.length == 4) {
//            dbusername = myDBParameters[0];
//            dbpassword = myDBParameters[1];
//            dbport = myDBParameters[2];
//            dbInstance = myDBParameters[3];
//        }
//    }

}
