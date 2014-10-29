/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACKAGES;

import it.sauronsoftware.cron4j.Predictor;
import it.sauronsoftware.cron4j.SchedulingPattern;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Javier
 */
public class FolderChecker {

    private static String stratDir = "C:\\STRATEGIES";

    private static List<String[]> readFiles(String str) {
        List<String[]> tb = new ArrayList();
        listFiles().stream().forEach((File f) -> {
            try {
                Files.lines(f.toPath()).forEach((String s) -> {
                    if (s.contains(str)) {
                        tb.add(s.split("\t"));
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return tb;
    }

    private static List<File> listFiles() {
        List<File> filesInFolder = null;
        try {
            filesInFolder = Files.walk(Paths.get(stratDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filesInFolder;
    }

    public static boolean existFiles() {
        return !listFiles().isEmpty();
    }

    public static Strategy readStrategy(File f) {
        String[] values = null;
        Strategy str = null;
        try {
            if(FolderChecker.validateStrategy(f)){
                 values = Files.lines(f.toPath()).findFirst().get().split("\\t");
                 str = new Strategy(values[0], values[1], values[2]);
            }
            else{
                System.err.println("ERROR. FILE DOES NOT CONTAIN A VALID STRATEGY");
            }
        } catch (IOException ex) {
            Logger.getLogger(FolderChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
    
    public static boolean validateStrategy(File f) {//STRATEGY VALIDATION
        String [] values;
        System.err.println("----VALIDATING "+f.getAbsolutePath()+"----");
        try {
             values = Files.lines(f.toPath()).findFirst().get().split("\\t");
             if(values!=null&&values.length==3){
                 System.err.println("The file has three arguments as expected");
                 //ADD VALIDATIONS FOR RMAN STRING, VALIDATE IF STRATEGY NAME DOESNT EXIST ALREADY
                 if(SchedulingPattern.validate(values[1])){
                     System.err.println("CRON String is valid "+values[1]);
                     Predictor pr = new Predictor(values[1]);
                     System.err.println("Next scheduled date "+pr.nextMatchingDate().toString());
                     return true;
                 } 
                 else{
                     System.err.println("INVALID CRON "+values[0]);
                 }
                 
             }
            
        } catch (IOException ex) {
            Logger.getLogger(FolderChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("INVALID FILE");
        return false;
    }
    
    
    public static void listenFolder(List<Strategy> stratList){//Checks if there are strategy files in the folder and parses them.
        if(FolderChecker.existFiles()){
            FolderChecker.listFiles().stream().forEach(
                    (file)->{
                        Strategy newstr = FolderChecker.readStrategy(file);
                        if(newstr!=null){
                            stratList.add(newstr);
                            boolean fileDeleted = file.delete();
                            if(fileDeleted)
                            System.err.println("Strategy file deleted as it was included in the system.");
                            else  System.err.println("UNABLE TO DELETE THE STRATEGY: CHECK PERMISSIONS");
                        }
                        else System.err.println("----ERROR PARSING A STRATEGY FILE FROM THE DESIGNATED FOLDER----");
                    
                    }
            
            );
            System.gc();
        }
    
    }

    public static String getStratDir() {
        return stratDir;
    }

    public static void setStratDir(String stratDir) {
        FolderChecker.stratDir = stratDir;
    }

}
