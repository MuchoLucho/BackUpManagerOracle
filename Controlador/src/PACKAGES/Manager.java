package PACKAGES;

import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

public class Manager implements Serializable {
    /*VARIABLES*/
    public static Object[][] table;
    public static DefaultTableModel tm = new DefaultTableModelImpl(
            null,
            new String[]{
                "Strategy", "Database", "Days", "Time", "Method"
            });

    /*METHODS*/

    public static Object[][] getTable(String str) {
        table = ConstructorFiles.toTableModel(str);
        return table;
    }

    public static void filter(String str) {
        tm.setDataVector(Manager.getTable(str), new String[]{"Strategy", "Database", "Time", "Method"});
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

    private static class DefaultTableModelImpl extends DefaultTableModel {

        public DefaultTableModelImpl(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }
        Class[] types = new Class[]{
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
