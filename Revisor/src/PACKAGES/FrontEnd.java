package PACKAGES;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrontEnd extends javax.swing.JFrame {

    public FrontEnd() {
        initComponents();
        table.setAutoCreateRowSorter(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        banner_lbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        reload_btn = new javax.swing.JButton();
        filter_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        filter_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        Help = new javax.swing.JMenu();
        time_drd = new javax.swing.JMenuItem();
        licenses_drd = new javax.swing.JMenuItem();
        third_party_drd = new javax.swing.JMenuItem();
        about_drd = new javax.swing.JMenuItem();
        fork_us_drd = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Revisor");
        setResizable(false);

        banner_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/banner.png"))); // NOI18N
        banner_lbl.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        reload_btn.setText("Reload");
        reload_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reload_btnActionPerformed(evt);
            }
        });

        jLabel1.setText("*Double Click on a row for details");

        filter_btn.setText("Filter");
        filter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reload_btn)
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(filter_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filter_btn)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reload_btn)
                    .addComponent(filter_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(filter_btn))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        table.setModel(PACKAGES.Manager.tm);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table);

        getContentPane().add(jScrollPane3, java.awt.BorderLayout.CENTER);

        Help.setText("Help");

        time_drd.setText("Undertanding Date & Time");
        time_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_drdActionPerformed(evt);
            }
        });
        Help.add(time_drd);

        licenses_drd.setText("License");
        licenses_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licenses_drdActionPerformed(evt);
            }
        });
        Help.add(licenses_drd);

        third_party_drd.setText("Third Party Libraries");
        third_party_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                third_party_drdActionPerformed(evt);
            }
        });
        Help.add(third_party_drd);

        about_drd.setText("About the Authors");
        about_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_drdActionPerformed(evt);
            }
        });
        Help.add(about_drd);

        fork_us_drd.setText("Get the Source Code");
        fork_us_drd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fork_us_drdActionPerformed(evt);
            }
        });
        Help.add(fork_us_drd);

        jMenuBar2.add(Help);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void reload_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reload_btnActionPerformed
        Manager.filter("\t");
    }//GEN-LAST:event_reload_btnActionPerformed

    private void filter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_btnActionPerformed
        if (!filter_txt.getText().isEmpty()) {
            Manager.filter(filter_txt.getText());
        } else {
            Manager.filter("\t");
        }
    }//GEN-LAST:event_filter_btnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() == 2) {
            javax.swing.JTable target = (javax.swing.JTable) evt.getSource();
            int row = target.getSelectedRow();
            String rman = (String) table.getModel().getValueAt(row, 5);
            JOptionPane.showMessageDialog(null,
                    Manager.outputRman(rman),
                    "Log " + rman, JOptionPane.INFORMATION_MESSAGE);
            //int column = target.getSelectedColumn();
            //System.out.println(row + "" + column);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void time_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_drdActionPerformed
        JOptionPane.showMessageDialog(null, new javax.swing.ImageIcon(getClass().getResource("/IMG/cron.gif")), "Time Syntax", -1);
    }//GEN-LAST:event_time_drdActionPerformed

    private void licenses_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licenses_drdActionPerformed
        JOptionPane.showMessageDialog(null, "This program is free software: you can redistribute it and/or modify\n"
            + "    it under the terms of the GNU General Public License as published by\n"
            + "    the Free Software Foundation, either version 3 of the License, or\n"
            + "    (at your option) any later version.\n"
            + "\n"
            + "    This program is distributed in the hope that it will be useful,\n"
            + "    but WITHOUT ANY WARRANTY; without even the implied warranty of\n"
            + "    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n"
            + "    GNU General Public License for more details.\n"
            + "\n"
            + "    You should have received a copy of the GNU General Public License\n"
            + "    along with this program.  If not, see <http://www.gnu.org/licenses/>.", "License GPLv3", -1, new javax.swing.ImageIcon(getClass().getResource("/IMG/gpl3.png")));
    }//GEN-LAST:event_licenses_drdActionPerformed

    private void third_party_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_third_party_drdActionPerformed
        JOptionPane.showMessageDialog(null, "For the Scheduler is in Use on the Executor Side\n"
            + "CRON4J by Sauron Software\n"
            + "cron4j is Free Software and it is licensed under LGPL\n", "Third Party Software", -1, new javax.swing.ImageIcon(getClass().getResource("/IMG/lgpl3.png")));
    }//GEN-LAST:event_third_party_drdActionPerformed

    private void about_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_drdActionPerformed
        JOptionPane.showMessageDialog(null, "This software was developed by Students\n"
            + "from National University of Costa Rica:  The truth makes us free\n\n"
            + "Javier Porras Valenzuela\n"
            + "Luis Carlos Segura Molina\n"
            + "Luis Enrique Ramírez Vargas\n"
            + "\nThe software was developed for Datbase Administration class\n"
            + "imparted by Msc. Johnny Villalobos Murillo", "About Students", -1, new javax.swing.ImageIcon(getClass().getResource("/IMG/una.png")));
    }//GEN-LAST:event_about_drdActionPerformed

    private void fork_us_drdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fork_us_drdActionPerformed
        if (JOptionPane.showOptionDialog(null, "All our Source Code is available \n in Github Servers"
            + "just fork us at \n https://github.com/lerv22/BackUpManagerOracle\n"
            + "\nDo you want to go to the site?", "Fork Us",
            JOptionPane.DEFAULT_OPTION, -1, new javax.swing.ImageIcon(getClass().getResource("/IMG/github.png")),
            new String[]{"No", "Yes"},
            "default") == 1) {
        try {
            Manager.openWebpage(new URL("https://github.com/lerv22/BackUpManagerOracle"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_fork_us_drdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem about_drd;
    private javax.swing.JLabel banner_lbl;
    private javax.swing.JButton filter_btn;
    private javax.swing.JTextField filter_txt;
    private javax.swing.JMenuItem fork_us_drd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem licenses_drd;
    private javax.swing.JButton reload_btn;
    private javax.swing.JTable table;
    private javax.swing.JMenuItem third_party_drd;
    private javax.swing.JMenuItem time_drd;
    // End of variables declaration//GEN-END:variables
}
