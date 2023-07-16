package RackVisionCinema.Admin;

import RackVisionCinema.Methods.Movie;

import java.awt.*;
import java.util.Objects;

public class AdminMoviePage extends javax.swing.JFrame
{

    public AdminMoviePage()
    {
        initComponents();
        m.tableLoad(movieTable);
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        javax.swing.ButtonGroup movieTypeGroup = new javax.swing.ButtonGroup();
        spgRBtn = new javax.swing.JRadioButton();
        gRBtn = new javax.swing.JRadioButton();
        pgRBtn = new javax.swing.JRadioButton();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JLabel backBtn = new javax.swing.JLabel();
        txtMovieTitle = new javax.swing.JTextField();
        txtMovieId = new javax.swing.JTextField();
        javax.swing.JLabel xButton = new javax.swing.JLabel();
        javax.swing.JLabel deleteBtn = new javax.swing.JLabel();
        javax.swing.JLabel updateBtn = new javax.swing.JLabel();
        txtMoviePrice = new javax.swing.JTextField();
        txtMovieDuration = new javax.swing.JTextField();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        movieTable = new javax.swing.JTable();
        javax.swing.JLabel saveBtn = new javax.swing.JLabel();
        javax.swing.JLabel searchBtn = new javax.swing.JLabel();
        javax.swing.JLabel refreshBtn = new javax.swing.JLabel();
        javax.swing.JLabel bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        movieTypeGroup.add(spgRBtn);
        spgRBtn.addActionListener(this::spgRBtnActionPerformed);
        getContentPane().add(spgRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 330, -1, -1));

        movieTypeGroup.add(gRBtn);
        gRBtn.addActionListener(this::gRBtnActionPerformed);
        getContentPane().add(gRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 330, -1, -1));

        movieTypeGroup.add(pgRBtn);
        pgRBtn.addActionListener(this::pgRBtnActionPerformed);
        getContentPane().add(pgRBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

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

        txtMovieTitle.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtMovieTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 254, 260, -1));

        txtMovieId.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtMovieId, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 740, 260, -1));

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

        deleteBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/DeleteButton.png")))); // NOI18N
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                deleteBtnMouseClicked();
            }
        });
        getContentPane().add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 557, -1, -1));

        updateBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Update.png")))); // NOI18N
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                updateBtnMouseClicked();
            }
        });
        getContentPane().add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, -1, -1));

        txtMoviePrice.setBackground(new java.awt.Color(233, 233, 233));
        getContentPane().add(txtMoviePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 464, 260, -1));

        txtMovieDuration.setBackground(new java.awt.Color(233, 233, 233));
        txtMovieDuration.setText("hh:mm:ss");
        getContentPane().add(txtMovieDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 393, 260, -1));

        movieTable.setFont(new java.awt.Font("Arial", Font.PLAIN, 14)); // NOI18N
        movieTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{

        }));
        jScrollPane1.setViewportView(movieTable);

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
        getContentPane().add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 504, -1, -1));

        searchBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/SearchButton.png")))); // NOI18N
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                searchBtnMouseClicked();
            }
        });
        getContentPane().add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 663, -1, -1));

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
                Objects.requireNonNull(getClass().getResource("/images/Movie.png")))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 832));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked()
    {//GEN-FIRST:event_backBtnMouseClicked
        AdminHomePage.main();
        dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    private void xButtonMouseClicked()
    {//GEN-FIRST:event_xButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_xButtonMouseClicked

    private void spgRBtnActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_spgRBtnActionPerformed
        if (spgRBtn.isSelected()) movieType = "SPG";
    }//GEN-LAST:event_spgRBtnActionPerformed

    private void pgRBtnActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_pgRBtnActionPerformed
        if (pgRBtn.isSelected()) movieType = "PG";
    }//GEN-LAST:event_pgRBtnActionPerformed

    private void gRBtnActionPerformed(java.awt.event.ActionEvent evt)
    {//GEN-FIRST:event_gRBtnActionPerformed
        if (gRBtn.isSelected()) movieType = "G";
    }//GEN-LAST:event_gRBtnActionPerformed

    private void saveBtnMouseClicked()
    {//GEN-FIRST:event_saveBtnMouseClicked
        m.setSave(txtMovieTitle, movieType, txtMovieDuration, txtMoviePrice);
        m.tableLoad(movieTable);
    }//GEN-LAST:event_saveBtnMouseClicked

    private void deleteBtnMouseClicked()
    {//GEN-FIRST:event_deleteBtnMouseClicked
        m.setDelete(txtMovieTitle, txtMoviePrice, txtMovieId);
        m.tableLoad(movieTable);
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void updateBtnMouseClicked()
    {//GEN-FIRST:event_updateBtnMouseClicked
        m.setUpdate(txtMovieTitle, txtMovieDuration, txtMoviePrice, txtMovieId, movieType);
        m.tableLoad(movieTable);
    }//GEN-LAST:event_updateBtnMouseClicked

    private void searchBtnMouseClicked()
    {//GEN-FIRST:event_searchBtnMouseClicked
        m.setSearch(txtMovieTitle, txtMovieDuration, txtMoviePrice, txtMovieId, txtMovieDuration);
        m.tableLoad(movieTable);
    }//GEN-LAST:event_searchBtnMouseClicked

    private void refreshBtnMouseClicked()
    {//GEN-FIRST:event_refreshBtnMouseClicked
        m.tableLoad(movieTable);
    }//GEN-LAST:event_refreshBtnMouseClicked

    public static void main()
    {
        java.awt.EventQueue.invokeLater(() -> new AdminMoviePage().setVisible(true));
    }

    private javax.swing.JRadioButton gRBtn;
    private javax.swing.JTable movieTable;
    private javax.swing.JRadioButton pgRBtn;
    private javax.swing.JRadioButton spgRBtn;
    private javax.swing.JTextField txtMovieDuration;
    private javax.swing.JTextField txtMovieId;
    private javax.swing.JTextField txtMoviePrice;
    private javax.swing.JTextField txtMovieTitle;
    // End of variables declaration//GEN-END:variables
    private String movieType = "";
    private final Movie m = new Movie();
}
