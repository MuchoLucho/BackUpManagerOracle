package PACKAGES;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class Manager {
    
    public static Object[][] table;
    
    public static DefaultTableModel tm = new DefaultTableModelImpl(
            Manager.getTable("\t"),
            new String[]{
                "Strategy", "Time", "Script", "Active", "Database"
            });
    
    public static Object[][] toTableModel(String str) {
        int i = 0;
        Object[] aux = readFiles(str).toArray();
        Object[] dummy;
        Object[][] ret = new Object[aux.length][5];
        String strategy, time, script, db;
        Boolean state;
        for (Object o : aux) {
            dummy = (Object[]) o;
            strategy = (String) dummy[0];
            time = (String) dummy[1];
            script = (String) dummy[2];
            state = ((String) dummy[3]).equals("true");
            db = (String) dummy[4];
            ret[i++] = new Object[]{strategy, time, script, state, db};
        }
        return ret;
    }
    
    static List<String[]> readFiles(String str) {
        List<String[]> tb = new ArrayList();
        listFiles().stream().forEach((File f) -> {
            try {
                Files.lines(f.toPath()).forEach((String s) -> {
                    if (s.contains(str)) {
                        tb.add(s.split("\t"));
                    }
                });
            } catch (IOException ex) {
                System.err.println("No files in the directory");
            }
        });
        return tb;
    }

    static List<String[]> changeFile(String str) {
        List<String[]> tb = new ArrayList();
        listFiles().stream().forEach((File f) -> {
            try {
                Files.lines(f.toPath()).forEach((String s) -> {
                    String[] split = s.split("\t");
                    if (split[0].equalsIgnoreCase(str) && split[3].equalsIgnoreCase("true")) {
                        tb.add(split);
                    }
                });
            } catch (IOException ex) {
                System.err.println("No strategies active in this directory");
            }
        });
        return tb;
    }
    
    private static List<File> listFiles() {
        List<File> filesInFolder = null;
        try {
            filesInFolder = Files.walk(Paths.get(System.getProperty("user.home") + "/narf/controller/strategies"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            System.err.println("No files in the directory");
            return filesInFolder;
        }
        return filesInFolder;
    }
    
    public static Object[][] getTable(String str) {
        table = toTableModel(str);
        return table;
    }
    
    public static void filter(String str) {
        tm.setDataVector(Manager.getTable(str), new String[]{
            "Strategy", "Time", "Script", "Active", "Database"
        });
    }
    
    public static String contentFile(String nameFile) {
        String path = System.getProperty("user.home") + "/narf/controller/rman_scripts/";
        Path p = FileSystems.getDefault().getPath(path, nameFile);
        StringBuilder str = new StringBuilder();
        try {
            Files.lines(p, StandardCharsets.UTF_8).forEach((String s) -> {
                str.append(s).append("\n");
            });
        } catch (IOException ex) {
            System.err.println("No files in the directory");
            return str.toString();
        }
        return str.toString();
    }
    
    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                System.err.println("URI Malformed");
            }
        }
    }
    
    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            System.err.println("URL Malformed");
        }
    }

    /*Inner class for the table*/
    private static class DefaultTableModelImpl extends DefaultTableModel {
        
        public DefaultTableModelImpl(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }
        Class[] types = new Class[]{
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean[]{
            false, false, false, false, false
        };
        
        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    }
}
