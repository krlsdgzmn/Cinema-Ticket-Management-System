package RackVisionCinema.Cashier;

import java.util.Objects;

public class CashierHomePage extends javax.swing.JFrame
{

    public CashierHomePage()
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        javax.swing.JLabel viewerBtn = new javax.swing.JLabel();
        javax.swing.JLabel movieBtn = new javax.swing.JLabel();
        javax.swing.JLabel cinemaRoomBtn = new javax.swing.JLabel();
        javax.swing.JLabel schedBtn = new javax.swing.JLabel();
        javax.swing.JLabel ticketBtn = new javax.swing.JLabel();
        javax.swing.JLabel xButton = new javax.swing.JLabel();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        javax.swing.JLabel bggg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewerBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Viewer Button.png")))); // NOI18N
        viewerBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                viewerBtnMouseClicked();
            }
        });
        getContentPane().add(viewerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 327, -1, -1));

        movieBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/Movie Button.png")))); // NOI18N
        movieBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                movieBtnMouseClicked();
            }
        });
        getContentPane().add(movieBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 406, -1, -1));

        cinemaRoomBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/CinemaRoomBtn.png")))); // NOI18N
        cinemaRoomBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                cinemaRoomBtnMouseClicked();
            }
        });
        getContentPane().add(cinemaRoomBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 485, -1, -1));

        schedBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/SchedBtn.png")))); // NOI18N
        schedBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                schedBtnMouseClicked();
            }
        });
        getContentPane().add(schedBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 564, -1, -1));

        ticketBtn.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/TicketBtn.png")))); // NOI18N
        ticketBtn.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                ticketBtnMouseClicked();
            }
        });
        getContentPane().add(ticketBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 643, -1, -1));

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

        bggg.setIcon(new javax.swing.ImageIcon(
                Objects.requireNonNull(getClass().getResource("/images/CashierPage.png")))); // NOI18N
        getContentPane().add(bggg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 832));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xButtonMouseClicked()
    {//GEN-FIRST:event_xButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_xButtonMouseClicked

    private void viewerBtnMouseClicked()
    {//GEN-FIRST:event_viewerBtnMouseClicked
        CashierViewerPage.main();
        dispose();
    }//GEN-LAST:event_viewerBtnMouseClicked

    private void movieBtnMouseClicked()
    {//GEN-FIRST:event_movieBtnMouseClicked
        CashierMoviePage.main();
        dispose();
    }//GEN-LAST:event_movieBtnMouseClicked

    private void cinemaRoomBtnMouseClicked()
    {//GEN-FIRST:event_cinemaRoomBtnMouseClicked
        CashierCinemaRoomPage.main();
        dispose();
    }//GEN-LAST:event_cinemaRoomBtnMouseClicked

    private void schedBtnMouseClicked()
    {//GEN-FIRST:event_schedBtnMouseClicked
        CashierSchedulePage.main();
        dispose();
    }//GEN-LAST:event_schedBtnMouseClicked

    private void ticketBtnMouseClicked()
    {//GEN-FIRST:event_ticketBtnMouseClicked
        CashierTicketPage.main();
        dispose();
    }//GEN-LAST:event_ticketBtnMouseClicked

    public static void main()
    {
        java.awt.EventQueue.invokeLater(() -> new CashierHomePage().setVisible(true));
    }

    // End of variables declaration//GEN-END:variables

}
