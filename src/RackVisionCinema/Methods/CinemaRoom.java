package RackVisionCinema.Methods;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaRoom extends Controller
{

    public void tableLoad(JTable cinemaRoomTable)
    {
        try
        {
            // Load cinema room table
            pst = con.prepareStatement("select * from CinemaRoom");
            ResultSet rs = pst.executeQuery();
            cinemaRoomTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setSave(JTextField txtCinemaRoomNo, JTextField txtCinemaRoomSeats)
    {

        String roomNo = txtCinemaRoomNo.getText();
        String seats = txtCinemaRoomSeats.getText();

        if (roomNo.isEmpty() || seats.isEmpty()) JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!seats.matches("[0-9]+") || Integer.parseInt(seats) < 1)
            JOptionPane.showMessageDialog(null, "Seats must be a number and at least 1.");
        else
        {
            try
            {
                // Check if room number already exists
                pst = con.prepareStatement("select * from CinemaRoom where RoomNo = ?");
                pst.setString(1, roomNo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) JOptionPane.showMessageDialog(null, "Room number already exists.");
                else
                {
                    // Insert into CinemaRoom(RoomNo, Seats) values(?, ?)
                    pst = con.prepareStatement("insert into CinemaRoom(RoomNo, Seats) values(?, ?)");
                    pst.setString(1, roomNo);
                    pst.setString(2, seats);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, roomNo + " added successfully.");

                    txtCinemaRoomNo.setText("");
                    txtCinemaRoomSeats.setText("");
                    txtCinemaRoomNo.requestFocus();
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setSearch(JTextField txtSearchId, JTextField txtCinemaRoomNo, JTextField txtCinemaRoomSeats)
    {
        String id = txtSearchId.getText();

        if (id.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter Room No.");
        else
        {
            try
            {
                // Check if room number exists
                pst = con.prepareStatement("select * from CinemaRoom where RoomNo = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, id + " does not exist.");
                else
                {
                    txtCinemaRoomNo.setText(rs.getString("RoomNo"));
                    txtCinemaRoomSeats.setText(rs.getString("Seats"));

                    JOptionPane.showMessageDialog(null, id + " found successfully.");
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setUpdate(JTextField txtSearchId, JTextField txtCinemaRoomNo, JTextField txtCinemaRoomSeats)
    {
        String id = txtSearchId.getText();
        String roomNo = txtCinemaRoomNo.getText();
        String seats = txtCinemaRoomSeats.getText();

        if (id.isEmpty() || roomNo.isEmpty() || seats.isEmpty())
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!seats.matches("[0-9]+") || Integer.parseInt(seats) < 1)
            JOptionPane.showMessageDialog(null, "Seats must be a number and at least 1.");
        else
        {
            try
            {
                // Check if cinema room ID exists
                pst = con.prepareStatement("select * from CinemaRoom where RoomNo = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, id + " does not exist.");
                else
                {
                    // Check if cinema room ID is referenced to Schedule Table
                    pst = con.prepareStatement("select RoomNo from Schedule where RoomNo = ?");
                    pst.setString(1, roomNo);
                    rs = pst.executeQuery();

                    if (rs.next() || !roomNo.equals(id)) JOptionPane.showMessageDialog(null,
                                                                                       "Cannot update: " + id + " is referenced to Schedule Table.");
                    else
                    {
                        // Update CinemaRoom set RoomNo = ?, Seats = ? where RoomNo = ?
                        pst = con.prepareStatement("update CinemaRoom set Seats = ? where RoomNo = ?");
                        pst.setString(1, roomNo);
                        pst.setString(2, seats);
                        pst.setString(3, id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, id + " updated successfully.");

                        txtSearchId.setText("");
                        txtCinemaRoomNo.setText("");
                        txtCinemaRoomSeats.setText("");
                        txtSearchId.requestFocus();
                    }
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setDelete(JTextField txtSearchId, JTextField txtCinemaRoomNo, JTextField txtCinemaRoomSeats)
    {
        String id = txtSearchId.getText();

        if (id.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter cinema room ID.");
        else
        {
            try
            {
                // Check if cinema room ID exists
                pst = con.prepareStatement("select * from CinemaRoom where RoomNo = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, id + " does not exist.");
                else
                {
                    // Check if cinema room ID is referenced to Schedule Table
                    pst = con.prepareStatement("select RoomNo from Schedule where RoomNo = ?");
                    pst.setString(1, id);
                    rs = pst.executeQuery();

                    if (rs.next())
                        JOptionPane.showMessageDialog(null, id + " in Schedule Table must be deleted first.");
                    else
                    {
                        // Delete from CinemaRoom where RoomNo = ?
                        pst = con.prepareStatement("delete from CinemaRoom where RoomNo = ?");
                        pst.setString(1, id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, id + " deleted successfully.");

                        txtSearchId.setText("");
                        txtCinemaRoomNo.setText("");
                        txtCinemaRoomSeats.setText("");
                        txtSearchId.requestFocus();
                    }
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
