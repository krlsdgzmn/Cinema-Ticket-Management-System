package RackVisionCinema.Methods;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Schedule extends Controller
{
    public void generateScheduleReport(JTextField txtMonth, JTextField txtYear)
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
                        "SELECT S.ScheduleID, CONCAT(S.SeatsTaken, '/', C.Seats) AS OccupiedSeats, DATE_FORMAT(S.ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, C.RoomNo, M.MovieTitle, M.MovieCategory, M.MovieDuration FROM Schedule S JOIN Movie M ON S.MovieID = M.MovieID JOIN CinemaRoom C ON C.RoomNo = S.RoomNo;");
                rs = pst.executeQuery();
                printQuery(rs);
            }
            else if (month.equals("*") && year.matches("[0-9]+"))
            {
                pst = con.prepareStatement(
                        "SELECT S.ScheduleID, CONCAT(S.SeatsTaken, '/', C.Seats) AS OccupiedSeats, DATE_FORMAT(S.ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, C.RoomNo, M.MovieTitle, M.MovieCategory, M.MovieDuration FROM Schedule S JOIN Movie M ON S.MovieID = M.MovieID JOIN CinemaRoom C ON C.RoomNo = S.RoomNo WHERE YEAR(S.ScreeningTime) = ?;");
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
                            "SELECT S.ScheduleID, CONCAT(S.SeatsTaken, '/', C.Seats) AS OccupiedSeats, DATE_FORMAT(S.ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, C.RoomNo, M.MovieTitle, M.MovieCategory, M.MovieDuration FROM Schedule S JOIN Movie M ON S.MovieID = M.MovieID JOIN CinemaRoom C ON C.RoomNo = S.RoomNo WHERE MONTH(S.ScreeningTime) = ?;");
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
                            "SELECT S.ScheduleID, CONCAT(S.SeatsTaken, '/', C.Seats) AS OccupiedSeats, DATE_FORMAT(S.ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, C.RoomNo, M.MovieTitle, M.MovieCategory, M.MovieDuration FROM Schedule S JOIN Movie M ON S.MovieID = M.MovieID JOIN CinemaRoom C ON C.RoomNo = S.RoomNo WHERE MONTH(S.ScreeningTime) = ? AND YEAR(S.ScreeningTime) = ?;");
                    pst.setString(1, month);
                    pst.setString(2, year);
                    rs = pst.executeQuery();
                    printQuery(rs);
                }
            }
            else JOptionPane.showMessageDialog(null, "Invalid month and year.");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void printQuery(ResultSet rs)
    {
        try
        {
            StringBuilder reportContent = new StringBuilder();
            reportContent.append("Schedule Report\n\n");

            while (rs.next())
            {
                reportContent.append("Schedule ID: ").append(rs.getInt("ScheduleID")).append("\n");
                reportContent.append("Ticket Bought: ").append(rs.getString("OccupiedSeats")).append("\n");
                reportContent.append("Screening Date & Time: ").append(rs.getString("ScreeningDateTime")).append("\n");
                reportContent.append("Room No: ").append(rs.getString("RoomNo")).append("\n");
                reportContent.append("Movie Title: ").append(rs.getString("MovieTitle")).append("\n");
                reportContent.append("Movie Category: ").append(rs.getString("MovieCategory")).append("\n");
                reportContent.append("Movie Duration: ").append(rs.getString("MovieDuration")).append("\n\n");
            }

            JTextArea textArea = new JTextArea(reportContent.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 500));
            JOptionPane.showMessageDialog(null, scrollPane, "Schedule Report", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private boolean isValidScreenTime(String screenTimeInput)
    {
        // Check if the given screen time is in the correct format
        Pattern screenTimePattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        return !screenTimePattern.matcher(screenTimeInput).matches();
    }

    public void tableLoad(JTable scheduleTable)
    {
        try
        {
            // Load the Schedule table
            pst = con.prepareStatement(
                    "SELECT ScheduleID, DATE_FORMAT(ScreeningTime, '%M %e, %Y - %h:%i:%s %p') AS ScreeningDateTime, CONCAT(Schedule.SeatsTaken, '/', CinemaRoom.Seats) AS OccupiedSeats, MovieID, Schedule.RoomNo FROM Schedule JOIN CinemaRoom ON Schedule.RoomNo = CinemaRoom.RoomNo;");
            ResultSet rs = pst.executeQuery();
            scheduleTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setSave(JTextField txtScreeningTime, JTextField txtMovieId, JTextField txtRoomNo)
    {
        String screenTime = txtScreeningTime.getText();
        String movieId = txtMovieId.getText();
        String roomNo = txtRoomNo.getText();

        if (screenTime.isEmpty() || movieId.isEmpty() || roomNo.isEmpty())
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!movieId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Movie ID must be a number.");
        else if (isValidScreenTime(screenTime))
            JOptionPane.showMessageDialog(null, "Enter a valid screen time. (yyyy-mm-dd hh:mm:ss)");
        else
        {
            try
            {
                // Check if the given movie ID exists in the Movie table
                pst = con.prepareStatement("SELECT MovieID FROM Movie WHERE MovieID = ?");
                pst.setString(1, movieId);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Movie ID " + movieId + " does not exist.");
                else
                {
                    // Check if the given room number exists in the CinemaRoom table
                    pst = con.prepareStatement("SELECT RoomNo FROM CinemaRoom WHERE RoomNo = ?");
                    pst.setString(1, roomNo);
                    rs = pst.executeQuery();

                    if (!rs.next()) JOptionPane.showMessageDialog(null, roomNo + " does not exist.");
                    else
                    {
                        // Check if there is a schedule conflict for the given room and screening time
                        pst = con.prepareStatement(
                                "SELECT ScheduleID FROM Schedule WHERE RoomNo = ? AND ScreeningTime = ?");
                        pst.setString(1, roomNo);
                        pst.setString(2, screenTime);
                        rs = pst.executeQuery();

                        if (rs.next()) JOptionPane.showMessageDialog(null,
                                                                     "There is already a schedule for the given room and screening time.");
                        else
                        {
                            // Insert the new schedule into the Schedule table
                            pst = con.prepareStatement(
                                    "INSERT INTO Schedule (ScreeningTime, MovieID, RoomNo) VALUES (?, ?, ?)");
                            pst.setString(1, screenTime);
                            pst.setString(2, movieId);
                            pst.setString(3, roomNo);
                            int rowsInserted = pst.executeUpdate();

                            if (rowsInserted > 0) JOptionPane.showMessageDialog(null, "Schedule added successfully.");
                            else JOptionPane.showMessageDialog(null, "Error adding schedule.");
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

    public void setDelete(JTextField txtSchedId)
    {
        String schedId = txtSchedId.getText();

        if (schedId.isEmpty()) JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!schedId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Schedule ID must be a number.");
        else
        {
            try
            {
                // Check if Schedule ID exists
                pst = con.prepareStatement("select ScheduleID from Schedule where ScheduleID = ?");
                pst.setString(1, schedId);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Schedule ID " + schedId + " does not exist.");
                else
                {
                    // Delete the schedule with the given Schedule ID
                    pst = con.prepareStatement("delete from Schedule where ScheduleID = ?");
                    pst.setString(1, schedId);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Schedule ID " + schedId + " successfully deleted.");
                    txtSchedId.setText("");
                    txtSchedId.requestFocus();
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setUpdate(JTextField txtSearchId, JTextField txtScreeningTime, JTextField txtMovieId, JTextField txtRoomNo)
    {
        String schedId = txtSearchId.getText();
        String screenTime = txtScreeningTime.getText();
        String movieId = txtMovieId.getText();
        String roomNo = txtRoomNo.getText();

        if (screenTime.isEmpty() || movieId.isEmpty() || roomNo.isEmpty() || schedId.isEmpty())
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!movieId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Movie ID must be a number.");
        else if (isValidScreenTime(screenTime))
            JOptionPane.showMessageDialog(null, "Enter a valid screen time. (yyyy-mm-dd hh:mm:ss)");
        else if (!schedId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Schedule ID must be a number.");
        else
        {
            try
            {
                // Check if Schedule ID exists
                pst = con.prepareStatement("select ScheduleID from Schedule where ScheduleID = ?");
                pst.setString(1, schedId);
                ResultSet rs = pst.executeQuery();
                if (!rs.next()) JOptionPane.showMessageDialog(null, "Schedule ID " + schedId + " does not exist.");
                else
                {
                    // Check if the given movie ID exists in the Movie table
                    pst = con.prepareStatement("SELECT MovieID FROM Movie WHERE MovieID = ?");
                    pst.setString(1, movieId);
                    rs = pst.executeQuery();

                    if (!rs.next()) JOptionPane.showMessageDialog(null, "Movie ID " + movieId + " does not exist.");
                    else
                    {
                        // Check if the given room number exists in the CinemaRoom table
                        pst = con.prepareStatement("SELECT RoomNo FROM CinemaRoom WHERE RoomNo = ?");
                        pst.setString(1, roomNo);
                        rs = pst.executeQuery();

                        if (!rs.next()) JOptionPane.showMessageDialog(null, roomNo + " does not exist.");
                        else
                        {
                            // Check if there is a schedule conflict for the given room and screening time
                            pst = con.prepareStatement(
                                    "SELECT ScheduleID FROM Schedule WHERE RoomNo = ? AND ScreeningTime = ?");
                            pst.setString(1, roomNo);
                            pst.setString(2, screenTime);
                            rs = pst.executeQuery();

                            if (rs.next()) JOptionPane.showMessageDialog(null,
                                                                         "There is already a schedule for the given room and screening time.");
                            else
                            {
                                // Insert the new schedule into the Schedule table
                                pst = con.prepareStatement(
                                        "update Schedule set ScreeningTime = ?, MovieID = ?, RoomNo = ? where ScheduleID = ?");
                                pst.setString(1, screenTime);
                                pst.setString(2, movieId);
                                pst.setString(3, roomNo);
                                pst.setString(4, schedId);
                                int rowsInserted = pst.executeUpdate();

                                if (rowsInserted > 0)
                                    JOptionPane.showMessageDialog(null, "Schedule added successfully.");
                                else JOptionPane.showMessageDialog(null, "Error adding schedule.");
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

    public void setSearch(JTextField txtSearchId, JTextField txtScreeningTime, JTextField txtMovieId, JTextField txtRoomNo)
    {
        String searchId = txtSearchId.getText();

        if (searchId.isEmpty()) JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!searchId.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Schedule ID must be a number.");
        else
        {
            try
            {
                // Check if Schedule ID exists
                pst = con.prepareStatement("select * from Schedule where ScheduleID = ?");
                pst.setString(1, searchId);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Search ID " + searchId + " does not exist.");
                else
                {
                    txtScreeningTime.setText(rs.getString("ScreeningTime"));
                    txtMovieId.setText(rs.getString("MovieID"));
                    txtRoomNo.setText(rs.getString("RoomNo"));
                    txtSearchId.requestFocus();
                    JOptionPane.showMessageDialog(null, "Search ID " + searchId + " found.");
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
