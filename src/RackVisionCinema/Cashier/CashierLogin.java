package RackVisionCinema.Cashier;

import RackVisionCinema.Methods.User;

import javax.swing.JOptionPane;
import java.util.Objects;

public class CashierLogin extends javax.swing.JFrame
{
    public CashierLogin()
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents()
    {

        // Variables declaration - do not modify                     
        javax.swing.JLabel backBtn = new javax.swing.JLabel();
        javax.swing.JLabel loginBtn = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        javax.swing.JLabel xButton = new javax.swing.JLabel();
        javax.swing.JLabel bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/BackButton.png")))); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                backBtnMouseClicked();
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 58, 40, 40));

        loginBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Login Button.png")))); // NOI18N
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                loginBtnMouseClicked();
            }
        });
        getContentPane().add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 525, -1, 80));

        txtUsername.setText("CashierID_123");
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 365, 280, 40));

        txtPassword.setText("cashier");
        txtPassword.setActionCommand("<Not Set>");
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 443, 280, 40));

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
                Objects.requireNonNull(getClass().getResource("/images/Cashier Page.png")))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 832));
        bg.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>                        

    private void loginBtnMouseClicked()
    {

        // Get username and password
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());

        // Check if username and password is correct with max login attempts             
        String CASHIER_ID = "CashierID_123";
        String PASSWORD = "cashier";
        if (username.equals(CASHIER_ID) && password.equals(PASSWORD) && loginAttempts <= 3)
        {
            JOptionPane.showMessageDialog(null, "Login Successful!");
            CashierHomePage.main();
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Login Failed!" + "\nAttempts remaining: " + (3 - loginAttempts));
            loginAttempts++;
        }

        if (loginAttempts > 3)
        {
            JOptionPane.showMessageDialog(null, "You have exceeded the maximum login attempts!");
            System.exit(0);
        }
    }

    private void backBtnMouseClicked()
    {//GEN-FIRST:event_backBtnMouseClicked
        User.main(null);
        dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    private void xButtonMouseClicked()
    {//GEN-FIRST:event_xButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_xButtonMouseClicked

    public static void main()
    {
        java.awt.EventQueue.invokeLater(() -> new CashierLogin().setVisible(true));
    }

    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private int loginAttempts = 0;
}
