package PACKAGES;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConstructorFiles {

    public static void Rman(String ts, int level, boolean log, boolean control) {
        try {
            File archivo = new File("pruebaIncremental.rman");
            try (FileWriter escribir = new FileWriter(archivo)) {
                escribir.write("connect target rmanuser/rmanuser@XE \n");
                escribir.write("connect catalog rmanuser/rmanuser@XE \n");
                escribir.write("run { \n");
                escribir.write("allocate channel c1 type disk; \n");
                //escribir.write("format 'c:\\Tablespaces\\ts1.rman'; \n");
                if (log) {
                    escribir.write("backup incremental level " + level + " tablespace " + ts + " plus archivelog; \n");
                } else {
                    escribir.write("backup incremental level " + level + " tablespace " + ts + " ; \n");
                }
                if (control) {
                    escribir.write("backup current controlfile; \n");
                }
                escribir.write("release channel c1; \n");
                escribir.write("} \n");
            }
        } catch (Exception e) {
        }
    }

    public static void Rman(String ts, int level, boolean log, boolean control, String tbs[]) {
        try {
            File archivo = new File("pruebaIncremental.rman");
            try (FileWriter escribir = new FileWriter(archivo)) {
                escribir.write("connect target / \n");
                escribir.write("connect catalog rmanuser/rmanuser@XE \n");
                escribir.write("run { \n");
                escribir.write("allocate channel c1 type disk; \n");
                //escribir.write("format 'c:\\Tablespaces\\ts1.rman'; \n");
                if (log) {
                    escribir.write("backup incremental level " + level + " tablespace " + ts + " plus archivelog; \n");
                } else {
                    escribir.write("backup incremental level " + level + " tablespace " + ts + " ; \n");
                }
                if (control) {
                    escribir.write("backup current controlfile; \n");
                }
                for (int i = 0; i < tbs.length; i++) {
                    escribir.write("backup tablespace " + tbs[i] + " tag='BACKUP_" + i);
                }
                escribir.write("release channel c1; \n");
                escribir.write("} \n");
            }
        } catch (Exception e) {
        }
    }

    public static void RmanFull(String db) {
        try {
            File archivo2 = new File("pruebaTotal.rman");
            try (FileWriter escribir2 = new FileWriter(archivo2)) {
                escribir2.write("connect target rmanuser/rmanuser@" + db + " \n");
                escribir2.write("connect catalog rmanuser/rmanuser@" + db + " \n");
                escribir2.write("run { \n");
                escribir2.write("backup database spfile plus archivelog;");
                escribir2.write("backup current controlfile; \n");
                escribir2.write("} \n");
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DBManager d1 = new DBManager();
        Rman("ts1", 0, true, true);
        RmanFull("XE");
        try {
            //Process p = Runtime.getRuntime().exec("rman @pruebaIncremental.rman");
            Process p = Runtime.getRuntime().exec("/oracle/product/db/bin/rman @pruebaTotal.rman");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("RMAN") || line.contains("ORA")) {
                    System.out.println("ERROR ");
                    //return false;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
