package RackVisionCinema.Admin;

import RackVisionCinema.Methods.Schedule;

import java.awt.*;
import java.util.Objects;

public class AdminSchedulePage extends javax.swing.JFrame {

    public AdminSchedulePage() {
        initComponents();
        s.tableLoad(scheduleTable);
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JLabel backBtn = new javax.swing.JLabel();
        txtMovieId = new javax.swing.JTextField();
        txtScheduleId = new javax.swing.JTextField();
        javax.swing.JLabel xButton = new javax.swing.JLabel();
        javax.swing.JLabel deleteBtn = new javax.swing.JLabel();
        javax.swing.JLabel updateBtn = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        txtRoomNo = new javax.swing.JTextField();
        txtScreeningTime = new javax.swing.JTextField();
        txtMonth = new javax.swing.JTextField();
        javax.swing.JLabel generateReport = new javax.swing.JLabel();
        javax.swing.JLabel reportbg = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        scheduleTable = new javax.swing.JTable();
        javax.swing.JLabel saveBtn = new javax.swing.JLabel();
        javax.swing.JLabel searchBtn = new javax.swing.JLabel();
        javax.swing.JLabel refreshBtn = new javax.swing.JLabel();
        javax.swing.JLabel bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/BackButton.png")))); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked();
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, 40));

        txtMovieId.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtMovieId, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 328, 260, -1));

        txtScheduleId.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtScheduleId, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 718, 260, -1));

        xButton.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/images/X.png")))); // NOI18N
        xButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xButtonMouseClicked();
            }
        });
        getContentPane().add(xButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1547, 17, -1, -1));

        deleteBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/DeleteButton.png")))); // NOI18N
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked();
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        updateBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Update.png")))); // NOI18N
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked();
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, -1, -1));

        txtYear.setBackground(new java.awt.Color(233, 233, 233));
        txtYear.setText("*");
        txtYear.setToolTipText("");
        getContentPane().add(txtYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 59, 130, -1));

        txtRoomNo.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 398, 260, -1));

        txtScreeningTime.setBackground(new java.awt.Color(233, 233, 233));
        txtScreeningTime.setText("yyyy-mm-dd hh:mm:ss");
        txtScreeningTime.setToolTipText("");
        getContentPane().add(txtScreeningTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 262, 260, -1));

        txtMonth.setBackground(new java.awt.Color(233, 233, 233));
        txtMonth.setText("*");
        txtMonth.setToolTipText("");
        getContentPane().add(txtMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(1042, 59, 130, -1));

        generateReport.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/generate report.png")))); // NOI18N
        generateReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generateReportMouseClicked();
            }
        });
        getContentPane().add(generateReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1371, 55, -1, -1));

        reportbg.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/reportbg.png")))); // NOI18N
        getContentPane().add(reportbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 0, 680, 140));

        scheduleTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 14)); // NOI18N
        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(scheduleTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 890, 475));

        saveBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Save Button.png")))); // NOI18N
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked();
            }
        });
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, -1, -1));

        searchBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/SearchButton.png")))); // NOI18N
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked();
            }
        });
        getContentPane().add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, -1, -1));

        refreshBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Refresh.png")))); // NOI18N
        refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBtnMouseClicked();
            }
        });
        getContentPane().add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 160, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/images/schedule.png")))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 832));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked() {//GEN-FIRST:event_backBtnMouseClicked
        AdminHomePage.main();
        dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    private void xButtonMouseClicked() {//GEN-FIRST:event_xButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_xButtonMouseClicked

    private void saveBtnMouseClicked() {//GEN-FIRST:event_saveBtnMouseClicked
        s.setSave(txtScreeningTime, txtMovieId, txtRoomNo);
        s.tableLoad(scheduleTable);
    }//GEN-LAST:event_saveBtnMouseClicked

    private void deleteBtnMouseClicked() {//GEN-FIRST:event_deleteBtnMouseClicked
        s.setDelete(txtScheduleId);
        s.tableLoad(scheduleTable);
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void updateBtnMouseClicked() {//GEN-FIRST:event_updateBtnMouseClicked
        s.setUpdate(txtScheduleId, txtScreeningTime, txtMovieId, txtRoomNo);
        s.tableLoad(scheduleTable);
    }//GEN-LAST:event_updateBtnMouseClicked

    private void searchBtnMouseClicked() {//GEN-FIRST:event_searchBtnMouseClicked
        s.setSearch(txtScheduleId, txtScreeningTime, txtMovieId, txtRoomNo);
        s.tableLoad(scheduleTable);
    }//GEN-LAST:event_searchBtnMouseClicked

    private void refreshBtnMouseClicked() {//GEN-FIRST:event_refreshBtnMouseClicked
        s.tableLoad(scheduleTable);
    }//GEN-LAST:event_refreshBtnMouseClicked

    private void generateReportMouseClicked() {//GEN-FIRST:event_generateReportMouseClicked
        s.generateScheduleReport(txtMonth, txtYear);
    }//GEN-LAST:event_generateReportMouseClicked

    public static void main() {
        java.awt.EventQueue.invokeLater(() -> new AdminSchedulePage().setVisible(true));
    }

    private javax.swing.JTable scheduleTable;
    private javax.swing.JTextField txtMonth;
    private javax.swing.JTextField txtMovieId;
    private javax.swing.JTextField txtRoomNo;
    private javax.swing.JTextField txtScheduleId;
    private javax.swing.JTextField txtScreeningTime;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
    private final Schedule s = new Schedule();
}
