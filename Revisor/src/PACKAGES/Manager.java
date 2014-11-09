package PACKAGES;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.table.DefaultTableModel;

/*TODO: HACER UN AUTOSORT EN LOS HEADERS DE LAS COLUMNAS */
public class Manager {

    public static Object[][] table;

    public static Object[][] getTable(String str) {
        table = Reader.toTableModel(str);
        return table;
    }

    public static DefaultTableModel tm = new DefaultTableModel(
            Manager.getTable("\t"),
            new String[]{
                "Strategy", "Database", "Date", "Hour", "Success", "Rman Output"
            }
    ) {
        Class[] types = new Class[]{
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean[]{
            false, false, false, false, false, false
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public static void filter(String str) {
        tm.setDataVector(Manager.getTable(str), new String[]{"Strategy", "Database", "Date", "Hour", "Success", "Rman Output"});
    }

    public static String outputRman(String str) {
        return Reader.contentFile(str);
    }

    public static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
            }
        }
    }

    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
        }
    }

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
}
