/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PACKAGES;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StrategyExecutor {

    private String rmanFile = null;
    private static String rmanScriptFolder = System.getProperty("user.home") + "/narf/executor/backup_files/~";

    public String executeCommand(String command) {

        StringBuffer output = new StringBuffer();
        //String[] environment = {"ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe"};
        Process p;
        try {
            p = Runtime.getRuntime().exec(command, null, null);
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

        return output.toString();

    }

    public String executeRMANFile(String rmanString) {//Parameter is name of file in the 
        String oracle_home = System.getenv("ORACLE_HOME");
        String rmanOutput = this.executeCommand(oracle_home + "/bin/rman @" + NARFDirs.scripts + rmanString);
        return rmanOutput;
    }

    public boolean sendResultLog(String logName) {//Success/fail test pending
        String logFullPath = NARFDirs.local_logs + logName;
        System.err.println("Trying to send logs to: " + "scp " + logFullPath + " " + NARFDirs.motherUser + "@" + NARFDirs.motherIP + ":" + NARFDirs.motherLogs);
        String output = this.executeCommand("scp " + logFullPath + " " + NARFDirs.motherUser + "@" + NARFDirs.motherIP + ":" + NARFDirs.motherLogs);
        System.err.println(output);
        return !output.contains("fail");
    }

    public boolean successfulStrategy(String rmanOutput) {
        System.out.println(rmanOutput);
        if (rmanOutput != null && !rmanOutput.isEmpty()) {
            return !((rmanOutput.contains("ORA-") && rmanOutput.contains("RMAN-")) || rmanOutput.contains("ERROR") || rmanOutput.contains("fail"));
        }
        return false;

    }

    public boolean sendResultOutput(String rmanOutput) {
        String outputFullPath = NARFDirs.local_outputs + rmanOutput;
        System.err.println("Trying to send logs to: " + "scp " + outputFullPath + " " + NARFDirs.motherUser + "@" + NARFDirs.motherIP + ":" + NARFDirs.motherOutputs);
        String output = this.executeCommand("scp " + outputFullPath + " " + NARFDirs.motherUser + "@" + NARFDirs.motherIP + ":" + NARFDirs.motherLogs);
        System.err.println(output);
        return !output.contains("fail");
    }

}
