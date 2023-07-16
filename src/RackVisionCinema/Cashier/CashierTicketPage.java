package RackVisionCinema.Cashier;

import RackVisionCinema.Methods.Ticket;

import java.awt.*;
import java.util.Objects;


public class CashierTicketPage extends javax.swing.JFrame
{

    public CashierTicketPage()
    {
        initComponents();
        t.tableLoad(ticketTable);
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        txtViewerId = new javax.swing.JTextField();
        txtSchedId = new javax.swing.JTextField();
        txtTicketId = new javax.swing.JTextField();
        javax.swing.JLabel saveBtn = new javax.swing.JLabel();
        javax.swing.JLabel searchBtn = new javax.swing.JLabel();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JLabel backBtn = new javax.swing.JLabel();
        javax.swing.JLabel xButton = new javax.swing.JLabel();
        javax.swing.JLabel refreshBtn = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        ticketTable = new javax.swing.JTable();
        txtYear = new javax.swing.JTextField();
        txtMonth = new javax.swing.JTextField();
        javax.swing.JLabel generateReport = new javax.swing.JLabel();
        javax.swing.JLabel reportbg = new javax.swing.JLabel();
        javax.swing.JLabel bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewerId.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtViewerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 348, 260, -1));

        txtSchedId.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtSchedId, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 262, 260, -1));

        txtTicketId.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtTicketId, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 719, 260, -1));

        saveBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Save Button.png")))); // NOI18N
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                saveBtnMouseClicked();
            }
        });
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, -1, -1));

        searchBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/SearchButton.png")))); // NOI18N
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                searchBtnMouseClicked();
            }
        });
        getContentPane().add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, -1, -1));

        backBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/BackButton.png")))); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                backBtnMouseClicked();
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 40, 40));

        xButton.setIcon(
                new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/images/X.png")))); // NOI18N
        xButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                xButtonMouseClicked();
            }
        });
        getContentPane().add(xButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1547, 17, -1, -1));

        refreshBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Refresh.png")))); // NOI18N
        refreshBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                refreshBtnMouseClicked();
            }
        });
        getContentPane().add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 160, -1, -1));

        ticketTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 14)); // NOI18N
        ticketTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{

        }));
        jScrollPane1.setViewportView(ticketTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 890, 475));

        txtYear.setBackground(new java.awt.Color(233, 233, 233));
        txtYear.setText("*");
        txtYear.setToolTipText("");
        getContentPane().add(txtYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 59, 130, -1));

        txtMonth.setBackground(new java.awt.Color(233, 233, 233));
        txtMonth.setText("*");
        txtMonth.setToolTipText("");
        getContentPane().add(txtMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(1042, 59, 130, -1));

        generateReport.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/generate report.png")))); // NOI18N
        generateReport.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                generateReportMouseClicked();
            }
        });
        getContentPane().add(generateReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(1371, 55, -1, -1));

        reportbg.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/reportbg.png")))); // NOI18N
        getContentPane().add(reportbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 0, 680, 140));

        bg.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Ticket.png")))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 832));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked()
    {//GEN-FIRST:event_backBtnMouseClicked
        CashierHomePage.main();
        dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    private void xButtonMouseClicked()
    {//GEN-FIRST:event_xButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_xButtonMouseClicked

    private void saveBtnMouseClicked()
    {//GEN-FIRST:event_saveBtnMouseClicked
        t.setSave(txtSchedId, txtViewerId);
        t.tableLoad(ticketTable);
    }//GEN-LAST:event_saveBtnMouseClicked

    private void searchBtnMouseClicked()
    {//GEN-FIRST:event_searchBtnMouseClicked
        t.setSearch(txtTicketId, txtSchedId, txtViewerId);
        t.tableLoad(ticketTable);
    }//GEN-LAST:event_searchBtnMouseClicked

    private void refreshBtnMouseClicked()
    {//GEN-FIRST:event_refreshBtnMouseClicked
        t.tableLoad(ticketTable);
    }//GEN-LAST:event_refreshBtnMouseClicked

    private void generateReportMouseClicked()
    {//GEN-FIRST:event_generateReportMouseClicked
        t.generateTicketReport(txtMonth, txtYear);
    }//GEN-LAST:event_generateReportMouseClicked

    public static void main()
    {
        java.awt.EventQueue.invokeLater(() -> new CashierTicketPage().setVisible(true));
    }

    private javax.swing.JTable ticketTable;
    private javax.swing.JTextField txtMonth;
    private javax.swing.JTextField txtSchedId;
    private javax.swing.JTextField txtTicketId;
    private javax.swing.JTextField txtViewerId;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
    private final Ticket t = new Ticket();
}
