package RackVisionCinema.Methods;

import RackVisionCinema.Cashier.CashierLogin;
import RackVisionCinema.Admin.AdminLogin;

import java.util.Objects;

public class User extends javax.swing.JFrame
{

    public User()
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JLabel adminBtn = new javax.swing.JLabel();
        javax.swing.JLabel cashierBtn = new javax.swing.JLabel();
        javax.swing.JLabel xButton = new javax.swing.JLabel();
        javax.swing.JLabel bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(1600, 832));
        setMinimumSize(new java.awt.Dimension(1600, 832));
        setName("mainPanel"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Admin Button.png")))); // NOI18N
        adminBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                adminBtnMouseClicked();
            }
        });
        getContentPane().add(adminBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, 60));

        cashierBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Cashier Button.png")))); // NOI18N
        cashierBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                cashierBtnMouseClicked();
            }
        });
        getContentPane().add(cashierBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, 60));

        xButton.setIcon(
                new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/images/XB.png")))); // NOI18N
        xButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                xButtonMouseClicked();
            }
        });
        getContentPane().add(xButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1547, 17, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Home Page.png")))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 832));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminBtnMouseClicked()
    {//GEN-FIRST:event_adminBtnMouseClicked
        AdminLogin.main();
        dispose();
    }//GEN-LAST:event_adminBtnMouseClicked

    private void cashierBtnMouseClicked()
    {//GEN-FIRST:event_cashierBtnMouseClicked
        CashierLogin.main();
        dispose();
    }//GEN-LAST:event_cashierBtnMouseClicked

    private void xButtonMouseClicked()
    {//GEN-FIRST:event_xButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_xButtonMouseClicked

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(() -> new User().setVisible(true));
    }

    // End of variables declaration//GEN-END:variables
}
