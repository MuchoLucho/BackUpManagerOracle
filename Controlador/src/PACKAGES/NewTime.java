package PACKAGES;

import javax.swing.SpinnerNumberModel;

public class NewTime extends javax.swing.JPanel {

    public NewTime() {
        initComponents();
        at_lbl.setEnabled(false);
        hour_spn.setEnabled(false);
        minute_spn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        time_grp = new javax.swing.ButtonGroup();
        mode_pnl = new javax.swing.JPanel();
        mode_lbl = new javax.swing.JLabel();
        mode_cmb = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        days_pnl = new javax.swing.JPanel();
        days_lbl = new javax.swing.JLabel();
        sunday_btn = new javax.swing.JToggleButton();
        thursday_btn = new javax.swing.JToggleButton();
        wednesday_btn = new javax.swing.JToggleButton();
        friday_btn = new javax.swing.JToggleButton();
        monday_btn = new javax.swing.JToggleButton();
        tuesday_btn = new javax.swing.JToggleButton();
        saturday_btn = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        time_pnl = new javax.swing.JPanel();
        time_lbl = new javax.swing.JLabel();
        interval_rdb = new javax.swing.JRadioButton();
        specific_rdn = new javax.swing.JRadioButton();
        execute_lbl = new javax.swing.JLabel();
        every_spn = new javax.swing.JSpinner();
        every_cmb = new javax.swing.JComboBox();
        at_lbl = new javax.swing.JLabel();
        hour_spn = new javax.swing.JSpinner();
        minute_spn = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        mode_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        mode_lbl.setForeground(new java.awt.Color(0, 0, 0));
        mode_lbl.setText("Mode");

        mode_cmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Weekly", "Monthly" }));
        mode_cmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mode_cmbItemStateChanged(evt);
            }
        });

        jLabel1.setText("*If Monthly is selected it will execute the first day of the month");

        javax.swing.GroupLayout mode_pnlLayout = new javax.swing.GroupLayout(mode_pnl);
        mode_pnl.setLayout(mode_pnlLayout);
        mode_pnlLayout.setHorizontalGroup(
            mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mode_pnlLayout.createSequentialGroup()
                .addGroup(mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mode_pnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mode_lbl))
                    .addGroup(mode_pnlLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mode_pnlLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addComponent(mode_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        mode_pnlLayout.setVerticalGroup(
            mode_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mode_pnlLayout.createSequentialGroup()
                .addComponent(mode_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mode_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        days_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        days_lbl.setForeground(new java.awt.Color(0, 0, 0));
        days_lbl.setText("Days");

        sunday_btn.setText("Sunday");

        thursday_btn.setText("Thursday");

        wednesday_btn.setText("Wednesday");

        friday_btn.setText("Friday");

        monday_btn.setText("Monday");

        tuesday_btn.setText("Tuesday");

        saturday_btn.setText("Saturday");

        jLabel2.setText("*No day of the week selected will be assumed as ALL days");

        javax.swing.GroupLayout days_pnlLayout = new javax.swing.GroupLayout(days_pnl);
        days_pnl.setLayout(days_pnlLayout);
        days_pnlLayout.setHorizontalGroup(
            days_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(days_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(days_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(days_pnlLayout.createSequentialGroup()
                        .addComponent(days_lbl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, days_pnlLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(days_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(days_pnlLayout.createSequentialGroup()
                                .addComponent(sunday_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monday_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tuesday_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wednesday_btn))
                            .addGroup(days_pnlLayout.createSequentialGroup()
                                .addComponent(thursday_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(friday_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saturday_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24))))
        );
        days_pnlLayout.setVerticalGroup(
            days_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, days_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(days_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(days_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wednesday_btn)
                    .addComponent(tuesday_btn)
                    .addComponent(monday_btn)
                    .addComponent(sunday_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(days_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(friday_btn)
                    .addComponent(thursday_btn)
                    .addComponent(saturday_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        time_lbl.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        time_lbl.setForeground(new java.awt.Color(0, 0, 0));
        time_lbl.setText("Time");

        time_grp.add(interval_rdb);
        interval_rdb.setSelected(true);
        interval_rdb.setText("Interval");
        interval_rdb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                interval_specific(evt);
            }
        });

        time_grp.add(specific_rdn);
        specific_rdn.setText("Specific");

        execute_lbl.setText("Execute Every");

        every_spn.setModel(spHour);

        every_cmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Hours","Minutes"}));
        every_cmb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                every_cmbItemStateChanged(evt);
            }
        });

        at_lbl.setText("At (24 h format)");

        hour_spn.setModel(spHour);

        minute_spn.setModel(spMin);

        jLabel4.setText(":");

        javax.swing.GroupLayout time_pnlLayout = new javax.swing.GroupLayout(time_pnl);
        time_pnl.setLayout(time_pnlLayout);
        time_pnlLayout.setHorizontalGroup(
            time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(time_pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(time_pnlLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specific_rdn)
                            .addComponent(interval_rdb)))
                    .addGroup(time_pnlLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(at_lbl)
                            .addComponent(execute_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(time_pnlLayout.createSequentialGroup()
                                .addComponent(every_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(every_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(time_pnlLayout.createSequentialGroup()
                                .addComponent(hour_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minute_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(time_lbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        time_pnlLayout.setVerticalGroup(
            time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(time_pnlLayout.createSequentialGroup()
                .addComponent(time_lbl)
                .addGap(12, 12, 12)
                .addComponent(interval_rdb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(execute_lbl)
                    .addComponent(every_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(every_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specific_rdn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(time_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(at_lbl)
                    .addComponent(hour_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minute_spn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(days_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mode_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(time_pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mode_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(days_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(time_pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void getTime(StringBuilder str) {
        this.getMinutes(str);//1st Value
        this.getHours(str);//2nd Value
        this.getMonths(str);//3rd Value & 4th Value
        this.getDaysOfWeek(str);//5th Value
    }

    private void getMinutes(StringBuilder str) {
        int num = spMin.getNumber().intValue();
        if (interval_rdb.isSelected()
                && every_cmb.getModel().getSelectedItem().equals("Minutes")
                && num != 60) {
            str.append("*/").append(num).append(" ");
        } else if (specific_rdn.isSelected()) {
            str.append(num).append(" ");
        } else if (every_cmb.getModel().getSelectedItem().equals("Hours")) {
            str.append("0 ");
        } else {
            str.append("* ");
        }
    }

    private void getHours(StringBuilder str) {
        int num = spHour.getNumber().intValue();
        if (interval_rdb.isSelected()
                && every_cmb.getModel().getSelectedItem().equals("Hours")
                && num != 24) {
            str.append("*/").append(num).append(" ");
        } else if (specific_rdn.isSelected()) {
            str.append(num).append(" ");
        } else {
            str.append("* ");
        }
    }

    private void getMonths(StringBuilder str) {
        if (mode_cmb.getModel().getSelectedItem().equals("Monthly")) {
            str.append("1 * ");
        } else {
            str.append("* * ");
        }
    }

    /*Get the days for the last CRON parameter*/
    private void getDaysOfWeek(StringBuilder str) {
        if (mode_cmb.getModel().getSelectedItem().equals("Weekly")) {
            int i = 0;
            if (sunday_btn.isSelected()) {
                str.append("0,");
                i++;
            }
            if (monday_btn.isSelected()) {
                str.append("1,");
                i++;
            }
            if (tuesday_btn.isSelected()) {
                str.append("2,");
                i++;
            }
            if (wednesday_btn.isSelected()) {
                str.append("3,");
                i++;
            }
            if (thursday_btn.isSelected()) {
                str.append("4,");
                i++;
            }
            if (friday_btn.isSelected()) {
                str.append("5,");
                i++;
            }
            if (saturday_btn.isSelected()) {
                str.append("6,");
                i++;
            }
            if (i == 0) {
                str.append("*,");
            }
            str.delete(str.length() - 1, str.length());
        } else {
            str.append("*");
        }
    }


    /*Listener for the change of the type (at specific hour or interval)*/
    private void interval_specific(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_interval_specific
        if (evt.getStateChange() == 1) {
            every_spn.setEnabled(true);
            every_cmb.setEnabled(true);
            execute_lbl.setEnabled(true);
            at_lbl.setEnabled(false);
            hour_spn.setEnabled(false);
            minute_spn.setEnabled(false);
            spHour.setMaximum(24);
            spHour.setMinimum(1);
            spMin.setMaximum(60);
            spMin.setMinimum(1);
        } else {
            every_spn.setEnabled(false);
            every_cmb.setEnabled(false);
            execute_lbl.setEnabled(false);
            at_lbl.setEnabled(true);
            hour_spn.setEnabled(true);
            minute_spn.setEnabled(true);
            spHour.setMaximum(23);
            spHour.setMinimum(0);
            spMin.setMaximum(59);
            spMin.setMinimum(0);
        }
    }//GEN-LAST:event_interval_specific

    /*Liste for the change of the mode*/
    private void mode_cmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mode_cmbItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            if (evt.getItem().equals("Monthly")) {
                sunday_btn.setEnabled(false);
                monday_btn.setEnabled(false);
                tuesday_btn.setEnabled(false);
                wednesday_btn.setEnabled(false);
                thursday_btn.setEnabled(false);
                friday_btn.setEnabled(false);
                saturday_btn.setEnabled(false);
                days_lbl.setEnabled(false);
            } else {
                sunday_btn.setEnabled(true);
                monday_btn.setEnabled(true);
                tuesday_btn.setEnabled(true);
                wednesday_btn.setEnabled(true);
                thursday_btn.setEnabled(true);
                friday_btn.setEnabled(true);
                saturday_btn.setEnabled(true);
                days_lbl.setEnabled(true);
            }
        }
    }//GEN-LAST:event_mode_cmbItemStateChanged

    private void every_cmbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_every_cmbItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            if (evt.getItem().equals("Hours")) {
                every_spn.setModel(spHour);
            } else {
                every_spn.setModel(spMin);
            }
        }
    }//GEN-LAST:event_every_cmbItemStateChanged

    /*VARIABLES*/
    private static final SpinnerNumberModel spHour = new javax.swing.SpinnerNumberModel(1, 0, 23, 1);
    private static final SpinnerNumberModel spMin = new javax.swing.SpinnerNumberModel(1, 0, 59, 1);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel at_lbl;
    private javax.swing.JLabel days_lbl;
    private javax.swing.JPanel days_pnl;
    private javax.swing.JComboBox every_cmb;
    private javax.swing.JSpinner every_spn;
    private javax.swing.JLabel execute_lbl;
    private javax.swing.JToggleButton friday_btn;
    private javax.swing.JSpinner hour_spn;
    private javax.swing.JRadioButton interval_rdb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSpinner minute_spn;
    private javax.swing.JComboBox mode_cmb;
    private javax.swing.JLabel mode_lbl;
    private javax.swing.JPanel mode_pnl;
    private javax.swing.JToggleButton monday_btn;
    private javax.swing.JToggleButton saturday_btn;
    private javax.swing.JRadioButton specific_rdn;
    private javax.swing.JToggleButton sunday_btn;
    private javax.swing.JToggleButton thursday_btn;
    private javax.swing.ButtonGroup time_grp;
    private javax.swing.JLabel time_lbl;
    private javax.swing.JPanel time_pnl;
    private javax.swing.JToggleButton tuesday_btn;
    private javax.swing.JToggleButton wednesday_btn;
    // End of variables declaration//GEN-END:variables
}
