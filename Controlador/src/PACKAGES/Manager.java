package PACKAGES;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

public class Manager {
    
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
    
    private static void createStrategy_btnActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.print(Arrays.toString(evt.getActionCommand().split(";")));
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
                Logger.getLogger(ConstructorFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return tb;
    }
    
    static String[] changeFile(String str) {
        List<String[]> tb = new ArrayList();
        listFiles().stream().forEach((File f) -> {
            try {
                Files.lines(f.toPath()).forEach((String s) -> {
                    if (s.contains(str) && s.contains("true")) {
                        tb.add(s.split("\t"));
                    }
                });
            } catch (IOException ex) {
                Logger.getLogger(ConstructorFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return tb.get(0);
    }
    
    private static List<File> listFiles() {
        List<File> filesInFolder = null;
        try {
            filesInFolder = Files.walk(Paths.get(System.getProperty("user.home") + "/narf/controller/strategies"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(ConstructorFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filesInFolder;
    }
    
    public static Object[][] table;
    
    public static Object[][] getTable(String str) {
        table = toTableModel(str);
        return table;
    }
    
    public static DefaultTableModel tm = new DefaultTableModelImpl(
            Manager.getTable("\t"),
            new String[]{
                "Strategy", "Time", "Script", "Active", "Database"
            });
    
    public static void filter(String str) {
        tm.setDataVector(Manager.getTable(str), new String[]{
            "Strategy", "Time", "Script", "Active", "Database"
        });
    }

    /*Main*/
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new FrontEnd().setVisible(true);
        });
    }

    /*Inner classes*/
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
