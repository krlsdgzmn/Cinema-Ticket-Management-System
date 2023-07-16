package RackVisionCinema.Cashier;

import RackVisionCinema.Methods.CinemaRoom;

import java.awt.*;
import java.util.Objects;

public class CashierCinemaRoomPage extends javax.swing.JFrame
{

    public CashierCinemaRoomPage()
    {
        initComponents();
        c.tableLoad(cinemaRoomTable);
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        txtSeats = new javax.swing.JTextField();
        txtRoomNo = new javax.swing.JTextField();
        txtRoomId = new javax.swing.JTextField();
        javax.swing.JLabel saveBtn = new javax.swing.JLabel();
        javax.swing.JLabel searchBtn = new javax.swing.JLabel();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JLabel backBtn = new javax.swing.JLabel();
        javax.swing.JLabel xButton = new javax.swing.JLabel();
        javax.swing.JLabel refreshBtn = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        cinemaRoomTable = new javax.swing.JTable();
        javax.swing.JLabel bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSeats.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 348, 260, -1));

        txtRoomNo.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 262, 260, -1));

        txtRoomId.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtRoomId, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 719, 260, -1));

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

        cinemaRoomTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 14)); // NOI18N
        cinemaRoomTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{

        }));
        jScrollPane1.setViewportView(cinemaRoomTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 890, 475));

        bg.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/cinemaroom.png")))); // NOI18N
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
        c.setSave(txtRoomNo, txtSeats);
        c.tableLoad(cinemaRoomTable);
    }//GEN-LAST:event_saveBtnMouseClicked

    private void searchBtnMouseClicked()
    {//GEN-FIRST:event_searchBtnMouseClicked
        c.setSearch(txtRoomId, txtRoomNo, txtSeats);
        c.tableLoad(cinemaRoomTable);
    }//GEN-LAST:event_searchBtnMouseClicked

    private void refreshBtnMouseClicked()
    {//GEN-FIRST:event_refreshBtnMouseClicked
        c.tableLoad(cinemaRoomTable);
    }//GEN-LAST:event_refreshBtnMouseClicked

    public static void main()
    {
        java.awt.EventQueue.invokeLater(() -> new CashierCinemaRoomPage().setVisible(true));
    }

    private javax.swing.JTable cinemaRoomTable;
    private javax.swing.JTextField txtRoomId;
    private javax.swing.JTextField txtRoomNo;
    private javax.swing.JTextField txtSeats;
    // End of variables declaration//GEN-END:variables
    private final CinemaRoom c = new CinemaRoom();
}
