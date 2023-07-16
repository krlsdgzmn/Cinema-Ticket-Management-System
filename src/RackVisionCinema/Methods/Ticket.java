package RackVisionCinema.Methods;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ticket extends Controller
{
    // Method to generate a ticket report
    public void generateTicketReport(JTextField txtMonth, JTextField txtYear)
    {
        String month = txtMonth.getText();
        String year = txtYear.getText();
        try
        {
            ResultSet rs;
            // Check if month and year are empty
            if (month.isEmpty() || year.isEmpty()) JOptionPane.showMessageDialog(null, "Please fill all fields.");
            else if (month.equals("*") && year.equals("*"))
            {
                pst = con.prepareStatement(
                        "SELECT T.TicketID, DATE_FORMAT(S.ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, C.RoomNo, M.MovieTitle, M.MovieCategory, M.MovieDuration, V.ViewerType, V.ViewerAge, M.MoviePrice, CONCAT(Vt.Discount * 100, '%') AS Discount, T.TicketPrice FROM Ticket T JOIN Schedule S ON T.ScheduleID = S.ScheduleID JOIN Movie M ON S.MovieID = M.MovieID JOIN Viewer V ON T.ViewerID = V.ViewerID JOIN ViewerType Vt ON V.ViewerType = Vt.TypeName JOIN CinemaRoom C ON C.RoomNo = S.RoomNo;");
                rs = pst.executeQuery();
                printQuery(rs);
            }
            else if (month.equals("*") && year.matches("[0-9]+"))
            {
                pst = con.prepareStatement(
                        "SELECT T.TicketID, DATE_FORMAT(S.ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, C.RoomNo, M.MovieTitle, M.MovieCategory, M.MovieDuration, V.ViewerType, V.ViewerAge, M.MoviePrice, CONCAT(Vt.Discount * 100, '%') AS Discount, T.TicketPrice FROM Ticket T JOIN Schedule S ON T.ScheduleID = S.ScheduleID JOIN Movie M ON S.MovieID = M.MovieID JOIN Viewer V ON T.ViewerID = V.ViewerID JOIN ViewerType Vt ON V.ViewerType = Vt.TypeName JOIN CinemaRoom C ON C.RoomNo = S.RoomNo WHERE YEAR(S.ScreeningTime) = ?;");
                pst.setString(1, year);
                rs = pst.executeQuery();
                printQuery(rs);
            }
            else if (month.matches("[0-9]+") && year.equals("*"))
            {
                if (Integer.parseInt(month) > 12) JOptionPane.showMessageDialog(null, "Invalid month.");
                else
                {
                    pst = con.prepareStatement(
                            "SELECT T.TicketID, DATE_FORMAT(S.ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, C.RoomNo, M.MovieTitle, M.MovieCategory, M.MovieDuration, V.ViewerType, V.ViewerAge, M.MoviePrice, CONCAT(Vt.Discount * 100, '%') AS Discount, T.TicketPrice FROM Ticket T JOIN Schedule S ON T.ScheduleID = S.ScheduleID JOIN Movie M ON S.MovieID = M.MovieID JOIN Viewer V ON T.ViewerID = V.ViewerID JOIN ViewerType Vt ON V.ViewerType = Vt.TypeName JOIN CinemaRoom C ON C.RoomNo = S.RoomNo WHERE MONTH(S.ScreeningTime) = ?;");
                    pst.setString(1, month);
                    rs = pst.executeQuery();
                    printQuery(rs);
                }
            }
            else if (month.matches("[0-9]+") && year.matches("[0-9]+"))
            {
                if (Integer.parseInt(month) > 12) JOptionPane.showMessageDialog(null, "Invalid month.");
                else
                {
                    pst = con.prepareStatement(
                            "SELECT T.TicketID, DATE_FORMAT(S.ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, C.RoomNo, M.MovieTitle, M.MovieCategory, M.MovieDuration, V.ViewerType, V.ViewerAge, M.MoviePrice, CONCAT(Vt.Discount * 100, '%') AS Discount, T.TicketPrice FROM Ticket T JOIN Schedule S ON T.ScheduleID = S.ScheduleID JOIN Movie M ON S.MovieID = M.MovieID JOIN Viewer V ON T.ViewerID = V.ViewerID JOIN ViewerType Vt ON V.ViewerType = Vt.TypeName JOIN CinemaRoom C ON C.RoomNo = S.RoomNo WHERE MONTH(S.ScreeningTime) = ? AND YEAR(S.ScreeningTime) = ?;");
                    pst.setString(1, month);
                    pst.setString(2, year);
                    rs = pst.executeQuery();
                    printQuery(rs);
                }
            }
            else JOptionPane.showMessageDialog(null, "Invalid month and year.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // Method to print query results
    public void printQuery(ResultSet rs)
    {
        try
        {
            StringBuilder reportContent = new StringBuilder();
            reportContent.append("Ticket Report\n\n");

            while (rs.next())
            {
                reportContent.append("Ticket ID: ").append(rs.getInt("TicketID")).append("\n");
                reportContent.append("Screening Date & Time: ").append(rs.getString("ScreeningDateTime")).append("\n");
                reportContent.append("Room No: ").append(rs.getString("RoomNo")).append("\n");
                reportContent.append("Movie Title: ").append(rs.getString("MovieTitle")).append("\n");
                reportContent.append("Movie Category: ").append(rs.getString("MovieCategory")).append("\n");
                reportContent.append("Movie Duration: ").append(rs.getString("MovieDuration")).append("\n");
                reportContent.append("Viewer Type: ").append(rs.getString("ViewerType")).append("\n");
                reportContent.append("Viewer Age: ").append(rs.getInt("ViewerAge")).append("\n");
                reportContent.append("Movie Price: ").append(rs.getDouble("MoviePrice")).append("\n");
                reportContent.append("Discount: ").append(rs.getString("Discount")).append("\n");
                reportContent.append("Ticket Price: ").append(rs.getDouble("TicketPrice")).append("\n\n");
            }

            JTextArea textArea = new JTextArea(reportContent.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            JOptionPane.showMessageDialog(null, scrollPane, "Ticket Report", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void tableLoad(JTable ticketTable)
    {
        try
        {
            // Load table from database
            pst = con.prepareStatement("select * from Ticket");
            ResultSet rs = pst.executeQuery();
            ticketTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setSave(JTextField txtSchedId, JTextField txtViewerId)
    {
        String schedId = txtSchedId.getText();
        String viewerId = txtViewerId.getText();

        if (schedId.isEmpty() || viewerId.isEmpty()) JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!schedId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Schedule ID must be a number.");
        else if (!viewerId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Viewer ID must be a number.");
        else
        {
            try
            {
                // Check if schedule id exists
                pst = con.prepareStatement("select ScheduleID from Schedule where ScheduleID = ?");
                pst.setString(1, schedId);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Schedule ID " + schedId + " does not exist.");
                else
                {
                    // Check if viewer id exists
                    pst = con.prepareStatement("select ViewerID from Viewer where ViewerID = ?");
                    pst.setString(1, viewerId);
                    rs = pst.executeQuery();

                    if (!rs.next()) JOptionPane.showMessageDialog(null, "Viewer ID " + viewerId + " does not exist.");
                    else
                    {
                        // Check if viewer id already purchased a ticket with the same schedule
                        pst = con.prepareStatement(
                                "select ViewerID, ScheduleID from Ticket where ViewerID = ? and ScheduleID = ?");
                        pst.setString(1, viewerId);
                        pst.setString(2, schedId);
                        rs = pst.executeQuery();

                        if (rs.next()) JOptionPane.showMessageDialog(null,
                                                                     "Viewer ID " + viewerId + " has already purchased a ticket with the same Schedule ID " + schedId);
                        else
                        {
                            // Select seats
                            pst = con.prepareStatement(
                                    "select Seats from CinemaRoom where RoomNo = (select RoomNo from Schedule where ScheduleID = ?)");
                            pst.setString(1, schedId);
                            rs = pst.executeQuery();
                            rs.next();
                            int seats = rs.getInt("Seats");

                            // Select seats taken
                            pst = con.prepareStatement("select SeatsTaken from Schedule where ScheduleID = ?");
                            pst.setString(1, schedId);
                            rs = pst.executeQuery();
                            rs.next();
                            int seatsTaken = rs.getInt("SeatsTaken");

                            // Check if seats from the cinema room are fully occupied
                            if (seatsTaken >= seats) JOptionPane.showMessageDialog(null,
                                                                                   "Seats from cinema room is fully occupied. Choose another schedule.");
                            else
                            {
                                // Select viewer discount
                                pst = con.prepareStatement(
                                        "select Discount from Viewer inner join ViewerType on ViewerType = TypeName where ViewerID = ?");
                                pst.setString(1, viewerId);
                                rs = pst.executeQuery();
                                rs.next();
                                double discount = rs.getDouble("Discount");

                                // Select movie price
                                pst = con.prepareStatement(
                                        "select MoviePrice from Movie where MovieID = (select MovieID from Schedule where ScheduleID = ?)");
                                pst.setString(1, schedId);
                                rs = pst.executeQuery();
                                rs.next();
                                double moviePrice = rs.getDouble("MoviePrice");

                                // Insert ticket
                                pst = con.prepareStatement(
                                        "insert into Ticket(ViewerID, ScheduleID, TicketPrice) values(?, ?, ?)");
                                pst.setString(1, viewerId);
                                pst.setString(2, schedId);
                                pst.setDouble(3, moviePrice - (moviePrice * discount));
                                pst.executeUpdate();

                                // Update SeatsTaken in Schedule table
                                pst = con.prepareStatement(
                                        "update Schedule set SeatsTaken = SeatsTaken + 1 where ScheduleID = ?");
                                pst.setString(1, schedId);
                                pst.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Ticket saved successfully.");

                                txtSchedId.setText("");
                                txtViewerId.setText("");
                                txtSchedId.requestFocus();
                            }
                        }
                    }
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setSearch(JTextField txtTicketId, JTextField txtSchedId, JTextField txtViewerId)
    {
        String ticketId = txtTicketId.getText();

        if (ticketId.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter movie ID.");
        else if (!ticketId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Movie ID must be a number.");
        else
        {
            try
            {
                // Check if ticket id exists
                pst = con.prepareStatement("select * from Ticket where TicketID = ?");
                pst.setString(1, ticketId);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Ticket ID " + ticketId + " does not exist.");
                else
                {
                    txtSchedId.setText(rs.getString("ScheduleID"));
                    txtViewerId.setText(rs.getString("ViewerID"));
                    JOptionPane.showMessageDialog(null, "Ticket ID " + ticketId + " found.");
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setDelete(JTextField txtTicketId)
    {
        String ticketId = txtTicketId.getText();

        if (ticketId.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter movie ID.");
        else if (!ticketId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Movie ID must be a number.");
        else
        {
            try
            {
                // Check if ticket id exists
                pst = con.prepareStatement("select * from Ticket where TicketID = ?");
                pst.setString(1, ticketId);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Ticket ID " + ticketId + " does not exist.");
                else
                {
                    // Check if schedule id exists
                    pst = con.prepareStatement("select ScheduleID from Ticket where TicketID = ?");
                    pst.setString(1, ticketId);
                    rs = pst.executeQuery();
                    rs.next();
                    String schedId = rs.getString("ScheduleID");

                    // Decrement SeatsTaken in Schedule table
                    pst = con.prepareStatement("update Schedule set SeatsTaken = SeatsTaken - 1 where ScheduleID = ?");
                    pst.setString(1, schedId);
                    pst.executeUpdate();

                    // Delete ticket
                    pst = con.prepareStatement("delete from Ticket where TicketID = ?");
                    pst.setString(1, ticketId);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Ticket ID " + ticketId + " deleted successfully.");
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setUpdate(JTextField txtTicketId, JTextField txtSchedId, JTextField txtViewerId)
    {
        String ticketId = txtTicketId.getText();
        String schedId = txtSchedId.getText();
        String viewerId = txtViewerId.getText();

        if (ticketId.isEmpty() || schedId.isEmpty() || viewerId.isEmpty())
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!ticketId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Ticket ID must be a number.");
        else if (!schedId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Schedule ID must be a number.");
        else if (!viewerId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Viewer ID must be a number.");
        else
        {
            try
            {
                // Check if ticket id exists
                pst = con.prepareStatement("select * from Ticket where TicketID = ?");
                pst.setString(1, ticketId);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Ticket ID " + ticketId + " does not exist.");
                else
                {
                    // Check if schedule id exists
                    pst = con.prepareStatement("select ScheduleID from Schedule where ScheduleID = ?");
                    pst.setString(1, schedId);
                    rs = pst.executeQuery();

                    if (!rs.next()) JOptionPane.showMessageDialog(null, "Schedule ID " + schedId + " does not exist.");
                    else
                    {
                        // Check if viewer id exists
                        pst = con.prepareStatement("select ViewerID from Viewer where ViewerID = ?");
                        pst.setString(1, viewerId);
                        rs = pst.executeQuery();

                        if (!rs.next())
                        {
                            JOptionPane.showMessageDialog(null, "Viewer ID " + viewerId + " does not exist.");
                        }
                        else
                        {
                            // Check if viewer id already purchased a ticket with the same schedule
                            pst = con.prepareStatement(
                                    "select ViewerID, ScheduleID from Ticket where ViewerID = ? and ScheduleID = ? and TicketID != ?");
                            pst.setString(1, viewerId);
                            pst.setString(2, schedId);
                            pst.setString(3, ticketId);
                            rs = pst.executeQuery();

                            if (rs.next()) JOptionPane.showMessageDialog(null,
                                                                         "Viewer ID " + viewerId + " has already purchased a ticket with the same Schedule ID " + schedId);
                            else
                            {
                                // Select viewer discount
                                pst = con.prepareStatement(
                                        "select Discount from Viewer inner join ViewerType on ViewerType = TypeName where ViewerID = ?");
                                pst.setString(1, viewerId);
                                rs = pst.executeQuery();
                                rs.next();
                                double discount = rs.getDouble("Discount");

                                // Select movie price
                                pst = con.prepareStatement(
                                        "select MoviePrice from Movie where MovieID = (select MovieID from Schedule where ScheduleID = ?)");
                                pst.setString(1, schedId);
                                rs = pst.executeQuery();
                                rs.next();
                                double moviePrice = rs.getDouble("MoviePrice");

                                // If schedule id changed, decrement old schedule seats taken and increment new schedule seats taken
                                pst = con.prepareStatement("select ScheduleID from Ticket where TicketID = ?");
                                pst.setString(1, ticketId);
                                rs = pst.executeQuery();
                                rs.next();
                                String oldSchedId = rs.getString("ScheduleID");

                                // Decrement old schedule seats taken
                                pst = con.prepareStatement(
                                        "update Schedule set SeatsTaken = SeatsTaken - 1 where ScheduleID = ?");
                                pst.setString(1, oldSchedId);
                                pst.executeUpdate();

                                // Decrement SeatsTaken in Schedule table
                                pst = con.prepareStatement(
                                        "update Schedule set SeatsTaken = SeatsTaken + 1 where ScheduleID = ?");
                                pst.setString(1, schedId);
                                pst.executeUpdate();

                                // Update ticket
                                pst = con.prepareStatement(
                                        "update Ticket set ViewerID = ?, ScheduleID = ?, TicketPrice = ? where TicketID = ?");
                                pst.setString(1, viewerId);
                                pst.setString(2, schedId);
                                pst.setDouble(3, moviePrice - (moviePrice * discount));
                                pst.setString(4, ticketId);
                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Ticket updated successfully.");

                                txtTicketId.setText("");
                                txtSchedId.setText("");
                                txtViewerId.setText("");
                                txtTicketId.requestFocus();
                            }
                        }
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
