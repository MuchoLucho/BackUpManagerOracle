package PACKAGES;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class StartUp {

    Loading l;

    public void start() {
        l = new Loading();
        new StartWorker().execute();
    }

    private class StartWorker extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            DBManager.llenado();
            return null;
        }

        @Override
        protected void done() {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    System.out.println(info.getName());
                    if ("GTK+".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(FrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            new FrontEnd().setVisible(true);
            l.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StartUp().start();
        });
    }
}
