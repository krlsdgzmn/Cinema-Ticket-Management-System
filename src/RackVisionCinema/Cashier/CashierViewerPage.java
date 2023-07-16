package RackVisionCinema.Cashier;

import RackVisionCinema.Methods.Viewer;

import java.awt.*;
import java.util.Objects;

public class CashierViewerPage extends javax.swing.JFrame
{

    public CashierViewerPage()
    {
        initComponents();
        v.tableLoad(viewerTable);
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        javax.swing.ButtonGroup viewerTypeGroup = new javax.swing.ButtonGroup();
        normalRBtn = new javax.swing.JRadioButton();
        studentRBtn = new javax.swing.JRadioButton();
        kidRBtn = new javax.swing.JRadioButton();
        seniorRBtn = new javax.swing.JRadioButton();
        pwdRBtn = new javax.swing.JRadioButton();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JLabel backBtn = new javax.swing.JLabel();
        txtViewerAge = new javax.swing.JTextField();
        txtViewerId = new javax.swing.JTextField();
        javax.swing.JLabel xButton = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        viewerTable = new javax.swing.JTable();
        javax.swing.JLabel saveBtn = new javax.swing.JLabel();
        javax.swing.JLabel searchBtn = new javax.swing.JLabel();
        javax.swing.JLabel refreshBtn = new javax.swing.JLabel();
        javax.swing.JLabel bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewerTypeGroup.add(normalRBtn);
        normalRBtn.addActionListener(this::normalRBtnActionPerformed);
        getContentPane().add(normalRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 265, -1, -1));

        viewerTypeGroup.add(studentRBtn);
        studentRBtn.addActionListener(this::studentRBtnActionPerformed);
        getContentPane().add(studentRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 333, -1, -1));

        viewerTypeGroup.add(kidRBtn);
        kidRBtn.addActionListener(this::kidRBtnActionPerformed);
        getContentPane().add(kidRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        viewerTypeGroup.add(seniorRBtn);
        seniorRBtn.addActionListener(this::seniorRBtnActionPerformed);
        getContentPane().add(seniorRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 300, -1, -1));

        viewerTypeGroup.add(pwdRBtn);
        pwdRBtn.addActionListener(this::pwdRBtnActionPerformed);
        getContentPane().add(pwdRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 266, -1, -1));

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

        txtViewerAge.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtViewerAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 398, 260, -1));

        txtViewerId.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtViewerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 719, 260, -1));

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

        viewerTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 14)); // NOI18N
        viewerTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{

        }));
        jScrollPane1.setViewportView(viewerTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 890, 475));

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

        bg.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Viewer.png")))); // NOI18N
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

    private void normalRBtnActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_normalRBtnActionPerformed
        if (normalRBtn.isSelected()) viewerType = "Normal";
    }//GEN-LAST:event_normalRBtnActionPerformed

    private void kidRBtnActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_kidRBtnActionPerformed
        if (kidRBtn.isSelected()) viewerType = "Kid";
    }//GEN-LAST:event_kidRBtnActionPerformed

    private void studentRBtnActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_studentRBtnActionPerformed
        if (studentRBtn.isSelected()) viewerType = "Student";
    }//GEN-LAST:event_studentRBtnActionPerformed

    private void seniorRBtnActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_seniorRBtnActionPerformed
        if (seniorRBtn.isSelected()) viewerType = "Senior";
    }//GEN-LAST:event_seniorRBtnActionPerformed

    private void pwdRBtnActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_pwdRBtnActionPerformed
        if (pwdRBtn.isSelected()) viewerType = "PWD";
    }//GEN-LAST:event_pwdRBtnActionPerformed

    private void saveBtnMouseClicked()
    {//GEN-FIRST:event_saveBtnMouseClicked
        v.setSave(txtViewerAge, viewerType);
        v.tableLoad(viewerTable);
    }//GEN-LAST:event_saveBtnMouseClicked

    private void searchBtnMouseClicked()
    {//GEN-FIRST:event_searchBtnMouseClicked
        v.setSearch(txtViewerId, txtViewerAge);
        v.tableLoad(viewerTable);
    }//GEN-LAST:event_searchBtnMouseClicked

    private void refreshBtnMouseClicked()
    {//GEN-FIRST:event_refreshBtnMouseClicked
        v.tableLoad(viewerTable);
    }//GEN-LAST:event_refreshBtnMouseClicked

    public static void main()
    {
        java.awt.EventQueue.invokeLater(() -> new CashierViewerPage().setVisible(true));
    }

    private javax.swing.JRadioButton kidRBtn;
    private javax.swing.JRadioButton normalRBtn;
    private javax.swing.JRadioButton pwdRBtn;
    private javax.swing.JRadioButton seniorRBtn;
    private javax.swing.JRadioButton studentRBtn;
    private javax.swing.JTextField txtViewerAge;
    private javax.swing.JTextField txtViewerId;
    private javax.swing.JTable viewerTable;
    // End of variables declaration//GEN-END:variables
    private String viewerType = "";
    private final Viewer v = new Viewer();
}
