package PACKAGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExeConnection {

    //String output = this.executeCommand("scp " + logFullPath + " " + NARFDirs.motherUser + "@" + NARFDirs.motherIP + ":" + NARFDirs.motherLogs);
    public static boolean sendFiles(String strategy, String destUser, String destIP) {
        String rmanFile = ConstructorFiles.rutaRman + strategy + ".rman";
        String stratFile = ConstructorFiles.rutaStrategies + strategy + ".txt";
        String rmanOutput = ExeConnection.executeCommand("scp " + rmanFile + " " + destUser + "@" + destIP + ":~/narf/executor/rman_scripts/");
        System.out.println("RMAN SEND OUTPUT" + rmanOutput);
        String stratOutput = ExeConnection.executeCommand("scp " + stratFile + " " + destUser + "@" + destIP + ":~/narf/executor/strategies/");
        return true;
    }

    public static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command, null, null);
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (IOException | InterruptedException e) {
        }
        return output.toString();
    }

}
