package PACKAGES;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.stream.Collectors;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FrontEnd extends javax.swing.JFrame {

    public FrontEnd() {
        this.tbs = new DefaultListModel();
        DBManager.llenado();
        initComponents();
        tbs();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modes_group = new javax.swing.ButtonGroup();
        time_group = new javax.swing.ButtonGroup();
        incLevel_group = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        stragedy_txt = new javax.swing.JTextField();
        type_lbl = new javax.swing.JLabel();
        full_rnd = new javax.swing.JRadioButton();
        incremetnal_rnd = new javax.swing.JRadioButton();
        total_rnd = new javax.swing.JRadioButton();
        name_lbl = new javax.swing.JLabel();
        lvl_1_rnd = new javax.swing.JRadioButton();
        lvl_0_rnd = new javax.swing.JRadioButton();
        level_lbl = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        date_txt = new javax.swing.JTextField();
        addEvt_btn = new javax.swing.JButton();
        delteEvt_btn = new javax.swing.JButton();
        time_lbl = new javax.swing.JLabel();
        tablespace_lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablespaces_lst = new javax.swing.JList();
        note_lbl = new javax.swing.JLabel();
        createStrategy_btn = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        database_lbl = new javax.swing.JLabel();
        databases_cmb = new javax.swing.JComboBox();
        control_rnd = new javax.swing.JCheckBox();
        archive_rnd = new javax.swing.JCheckBox();
        include_lbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        banner_lbl = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        filter_txt = new javax.swing.JTextField();
        filter_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NARF BU Manager");
        setResizable(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/banner.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3)
        );

        type_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        type_lbl.setForeground(new java.awt.Color(0, 0, 0));
        type_lbl.setText("BackUp Mode");

        modes_group.add(full_rnd);
        full_rnd.setSelected(true);
        full_rnd.setText("Full BackUp");
        full_rnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mode_change(evt);
            }
        });

        modes_group.add(incremetnal_rnd);
        incremetnal_rnd.setText("Incremental BackUp");
        incremetnal_rnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mode_change(evt);
            }
        });

        modes_group.add(total_rnd);
        total_rnd.setText("Whole BackUp");
        total_rnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mode_change(evt);
            }
        });

        name_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        name_lbl.setForeground(new java.awt.Color(0, 0, 0));
        name_lbl.setText("Name of Strategy");

        incLevel_group.add(lvl_1_rnd);
        lvl_1_rnd.setText("1");
        lvl_1_rnd.setEnabled(false);

        incLevel_group.add(lvl_0_rnd);
        lvl_0_rnd.setSelected(true);
        lvl_0_rnd.setText("0");
        lvl_0_rnd.setEnabled(false);

        level_lbl.setText("Level");
        level_lbl.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name_lbl))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(stragedy_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(full_rnd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_rnd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incremetnal_rnd, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(level_lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lvl_0_rnd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lvl_1_rnd)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_lbl)
                    .addComponent(type_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stragedy_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_rnd)
                    .addComponent(full_rnd)
                    .addComponent(incremetnal_rnd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lvl_1_rnd)
                    .addComponent(lvl_0_rnd)
                    .addComponent(level_lbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        date_txt.setEditable(false);

        addEvt_btn.setText("Add Event");
        addEvt_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEvt_btnActionPerformed(evt);
            }
        });

        delteEvt_btn.setText("Delete All Events");
        delteEvt_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delteEvt_btnActionPerformed(evt);
            }
        });

        time_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        time_lbl.setForeground(new java.awt.Color(0, 0, 0));
        time_lbl.setText("Date & Time");

        tablespace_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        tablespace_lbl.setForeground(new java.awt.Color(0, 0, 0));
        tablespace_lbl.setText("Tablespace");

        tablespaces_lst.setModel(tbs);
        tablespaces_lst.setSelectedIndex(1);
        tablespaces_lst.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jScrollPane1.setViewportView(tablespaces_lst);

        note_lbl.setText("*Press Ctrl+Click to add more than one TBs");

        createStrategy_btn.setText("Create Stragedy");
        createStrategy_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStrategy_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tablespace_lbl)
                        .addGap(258, 258, 258)
                        .addComponent(time_lbl))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(note_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date_txt)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(addEvt_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delteEvt_btn))
                            .addComponent(createStrategy_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time_lbl)
                    .addComponent(tablespace_lbl))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(note_lbl))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addEvt_btn)
                            .addComponent(delteEvt_btn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createStrategy_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        database_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        database_lbl.setForeground(new java.awt.Color(0, 0, 0));
        database_lbl.setText("Database");

        databases_cmb.setModel(databases());
        databases_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databases_cmbActionPerformed(evt);
            }
        });

        control_rnd.setText("Control Files");

        archive_rnd.setText("ArchiveLogs");

        include_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        include_lbl.setForeground(new java.awt.Color(0, 0, 0));
        include_lbl.setText("Include");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(database_lbl)
                        .addGap(282, 282, 282)
                        .addComponent(include_lbl))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(databases_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(archive_rnd)
                        .addGap(18, 18, 18)
                        .addComponent(control_rnd)))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(database_lbl)
                    .addComponent(include_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(databases_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(archive_rnd)
                    .addComponent(control_rnd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Create new Strategy", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        banner_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/banner.png"))); // NOI18N
        banner_lbl.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        filter_btn.setText("Filter");
        filter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(581, Short.MAX_VALUE)
                .addComponent(filter_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filter_btn))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filter_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filter_btn))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        table.setModel(PACKAGES.Manager.tm);
        jScrollPane3.setViewportView(table);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("View all Strategies", jPanel2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        jMenu1.setText("Help");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_btnActionPerformed
        if (!filter_txt.getText().isEmpty()) {
            Manager.filter(filter_txt.getText());
        } else {
            Manager.filter("\t");
        }
    }//GEN-LAST:event_filter_btnActionPerformed

    @SuppressWarnings("null")
    private void addEvt_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEvt_btnActionPerformed
        NewTime nt = new NewTime();
        int i = 1;
        StringBuilder str = new StringBuilder();
        do {
            switch (i) {
                case 0:
                    str = null;
                    i = 100;
                    break;
                case 1:
                    i = JOptionPane.showOptionDialog(null, nt, "New Time",
                            JOptionPane.DEFAULT_OPTION, -1, null,
                            new String[]{"Abort", "Add another",
                                "Save & Exit"},
                            "default");
                    nt.getTime(str);
                    nt = new NewTime();
                    str.append("|");
                    break;
                case 2:
                    date_txt.setText(str.toString().substring(0, str.length() - 1));
                    i = 100;
                    break;
                default:
                    break;
            }
        } while (i != 100);
    }//GEN-LAST:event_addEvt_btnActionPerformed

    private void delteEvt_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delteEvt_btnActionPerformed
        date_txt.setText("");
    }//GEN-LAST:event_delteEvt_btnActionPerformed

    private void databases_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databases_cmbActionPerformed
        tbs();
    }//GEN-LAST:event_databases_cmbActionPerformed

    private void createStragedy() {
        tablespaces_lst.getSelectedValuesList();
        String name = stragedy_txt.getText();
        String db = (String) databases_cmb.getModel().getSelectedItem();
        String time = date_txt.getText();
    }

    private void mode_change(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mode_change
        for (Enumeration<AbstractButton> buttons = modes_group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                switch (button.getText()) {
                    case "Whole BackUp":
                        control_rnd.setSelected(true);
                        control_rnd.setEnabled(false);
                        note_lbl.setEnabled(false);
                        tablespace_lbl.setEnabled(false);
                        tablespaces_lst.setSelectionInterval(0, tbs.getSize());
                        tablespaces_lst.setEnabled(false);
                        level_lbl.setEnabled(false);
                        lvl_0_rnd.setEnabled(false);
                        lvl_1_rnd.setEnabled(false);
                        break;
                    case "Incremental BackUp":
                        control_rnd.setEnabled(true);
                        note_lbl.setEnabled(true);
                        tablespace_lbl.setEnabled(true);
                        tablespaces_lst.setSelectedIndex(0);
                        tablespaces_lst.setEnabled(true);
                        level_lbl.setEnabled(true);
                        lvl_0_rnd.setEnabled(true);
                        lvl_1_rnd.setEnabled(true);
                        break;
                    case "Full BackUp":
                        control_rnd.setEnabled(true);
                        note_lbl.setEnabled(true);
                        tablespace_lbl.setEnabled(true);
                        tablespaces_lst.setSelectedIndex(0);
                        tablespaces_lst.setEnabled(true);
                        level_lbl.setEnabled(false);
                        lvl_0_rnd.setEnabled(false);
                        lvl_1_rnd.setEnabled(false);
                        break;
                }
            }
        }
    }//GEN-LAST:event_mode_change

    private void createStrategy_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStrategy_btnActionPerformed
        createStragedy();
    }//GEN-LAST:event_createStrategy_btnActionPerformed

    public javax.swing.ComboBoxModel databases() {
        java.util.ArrayList<String> vect = (ArrayList<String>) DBManager.getDbs().values().stream().map((x) -> x.getLink_name()).collect(Collectors.toList());
        return new javax.swing.DefaultComboBoxModel(vect.toArray());
    }

    private void tbs() {
        if (!tbs.isEmpty()) {
            tbs.clear();
        }
        DBManager.getDbs().get((String) databases_cmb.getModel().getSelectedItem()).getTablespaces().stream().forEach((str) -> {
            tbs.addElement(str);
        });
        tablespaces_lst.setSelectedIndex(0);
    }

    private final javax.swing.DefaultListModel tbs;
    private javax.swing.table.TableModel tabla;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEvt_btn;
    private javax.swing.JCheckBox archive_rnd;
    private javax.swing.JLabel banner_lbl;
    private javax.swing.JCheckBox control_rnd;
    private javax.swing.JButton createStrategy_btn;
    private javax.swing.JLabel database_lbl;
    private javax.swing.JComboBox databases_cmb;
    private javax.swing.JTextField date_txt;
    private javax.swing.JButton delteEvt_btn;
    private javax.swing.JButton filter_btn;
    private javax.swing.JTextField filter_txt;
    private javax.swing.JRadioButton full_rnd;
    private javax.swing.ButtonGroup incLevel_group;
    private javax.swing.JLabel include_lbl;
    private javax.swing.JRadioButton incremetnal_rnd;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel level_lbl;
    private javax.swing.JRadioButton lvl_0_rnd;
    private javax.swing.JRadioButton lvl_1_rnd;
    private javax.swing.ButtonGroup modes_group;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JLabel note_lbl;
    private javax.swing.JTextField stragedy_txt;
    private javax.swing.JTable table;
    private javax.swing.JLabel tablespace_lbl;
    private javax.swing.JList tablespaces_lst;
    private javax.swing.ButtonGroup time_group;
    private javax.swing.JLabel time_lbl;
    private javax.swing.JRadioButton total_rnd;
    private javax.swing.JLabel type_lbl;
    // End of variables declaration//GEN-END:variables
}
