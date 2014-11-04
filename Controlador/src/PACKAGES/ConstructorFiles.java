package PACKAGES;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConstructorFiles {

    public void createRmanFile() {
    }

    public void createStrategyFile() {
        
    }

    public static void RmanIncremental(String db, String rman, int level, boolean log, boolean control, String tbs[]) {
        //Metodo encargado de general el script para su posterior ejecucion
        //rman : nombre de la estrategia
        //ts : Tablespace a respaldar
        //level : Nivel de respaldo a generar (0 o 1)
        //log : Si se desea o no respaldar los log files
        //control : Si se desea respaldar los control files
        //tbs[] : Array de todos los tablespaces que se quieran respaldar
        //DB : Base de datos a utilizar 
        StringBuilder Tbs = new StringBuilder();
        try {
            File archivo = new File(rutaRman + rman + ".rman");
            try (FileWriter escribir = new FileWriter(archivo)) {
                escribir.write("connect target rmanuser/rmanuser@" + db + " \n");
                escribir.write("connect catalog rmanuser/rmanuser@" + db + " \n");
                escribir.write("run { \n");
                escribir.write("allocate channel c1 type disk; \n");
                for (String tb : tbs) {
                    Tbs.append(tb).append(",");
                }
                Tbs.delete(Tbs.length() - 1, Tbs.length());
                if (log) {
                    escribir.write("backup incremental level " + level + " tablespace " + Tbs + " plus archivelog; \n");
                } else {
                    escribir.write("backup incremental level " + level + " tablespace " + Tbs + " ; \n");
                }
                if (control) {
                    escribir.write("backup current controlfile; \n");
                }
                escribir.write("release channel c1; \n");
                escribir.write("} \n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RmanFull(String rman, String db, String tbs[]) {
        //rman : Nombre de la estrategia
        //DB : Base de datos a utilizar
        //tbs[] : Array de los tablespaces
        StringBuilder Tbs = new StringBuilder();
        try {
            File archivo2 = new File(rutaRman + rman + ".rman");
            try (FileWriter escribir2 = new FileWriter(archivo2)) {
                escribir2.write("connect target rmanuser/rmanuser@" + db + " \n");
                escribir2.write("connect catalog rmanuser/rmanuser@" + db + " \n");
                escribir2.write("run { \n");
                for (String tb : tbs) {
                    Tbs.append(tb).append(", ");
                }
                Tbs.delete(Tbs.length() - 1, Tbs.length());
                escribir2.write("backup tablespace " + Tbs + "; \n");
                escribir2.write("} \n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RmanWhole(String rman, String db, boolean logfiles) {

        // Este metodo genera un respaldo total de la base de datos
        //rman : Nombre de la estrategia
        //DB : Nombre de la base de datos
        //logFIles: Si se desean incluir o no los logfiles
        try {
            File archivo3 = new File(rutaRman + rman + ".rman");
            try (FileWriter escribir3 = new FileWriter(archivo3)) {
                escribir3.write("connect target rmanuser/rmanuser@" + db + " \n");
                escribir3.write("connect catalog rmanuser/rmanuser@" + db + " \n");
                escribir3.write("run { \n");
                if (logfiles) {
                    escribir3.write("BACKUP AS BACKUPSET DATABASE PLUS ARCHIVELOG;");
                } else {
                    escribir3.write("BACKUP AS BACKUPSET DATABASE");
                }
                escribir3.write("backup current controlfile; \n");
                escribir3.write("} \n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBManager d1 = new DBManager();
        String lis[] = {"users"};
        RmanIncremental("XE", "pruebaIncremental", 0, true, true, lis);
        RmanFull("pruebaFull", "XE", lis);
        RmanWhole("pruebaTotal", "XE", true);
        try {
            Process p = Runtime.getRuntime().exec("rman @" + rutaRman + "pruebaTotal.rman");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("RMAN") || line.contains("ORA")) {
                    //System.out.println("ERROR ");
                    //return false;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final static String rutaRman = System.getProperty("user.home") + "/narf/controller/rman_scripts/";
    public final static String rutaStrategies = System.getProperty("user.home") + "/narf/controller/strategies/";
}
