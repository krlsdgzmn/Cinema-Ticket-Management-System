package RackVisionCinema.Methods;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Movie extends Controller
{

    private boolean isValidTime(String timeInput)
    {
        // Regular expression pattern for time format hh:mm:ss
        Pattern timePattern = Pattern.compile("^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");
        return !timePattern.matcher(timeInput).matches();
    }

    public void tableLoad(JTable movieTable)
    {
        try
        {
            // Load movie table
            pst = con.prepareStatement("select * from Movie");
            ResultSet rs = pst.executeQuery();
            movieTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setSave(JTextField txtMovieTitle, String category, JTextField txtMovieDuration, JTextField txtMoviePrice)
    {
        String title = txtMovieTitle.getText();
        String duration = txtMovieDuration.getText();
        String price = txtMoviePrice.getText();

        if (title.isEmpty() || duration.isEmpty() || price.isEmpty() || category.isEmpty())
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!price.matches("[0.0-9]+") || Double.parseDouble(price) < 1.0)
            JOptionPane.showMessageDialog(null, "Price must be a number and at least 1.");
        else if (isValidTime(duration)) JOptionPane.showMessageDialog(null, "Enter a valid movie duration. (hh:mm:ss)");
        else
        {
            try
            {
                // Select * from Movie where MovieTitle = ?, if all fields are the same, then movie exists
                pst = con.prepareStatement("select * from Movie where MovieTitle = ?");
                pst.setString(1, title);
                ResultSet rs = pst.executeQuery();

                // Compare all fields
                if (rs.next() && rs.getString("MovieCategory").equals(category) && rs.getString("MovieDuration").equals(
                        duration) && rs.getDouble("MoviePrice") == Double.parseDouble(price))
                    JOptionPane.showMessageDialog(null, "Movie already exists.");
                else
                {
                    // Insert movie into Movie table
                    pst = con.prepareStatement(
                            "insert into Movie(MovieTitle, MovieCategory, MovieDuration, MoviePrice) values(?, ?, ?, ?)");
                    pst.setString(1, title);
                    pst.setString(2, category);
                    pst.setString(3, duration);
                    pst.setDouble(4, Double.parseDouble(price));
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Movie " + title + " added successfully.");

                    txtMovieTitle.setText("");
                    txtMovieDuration.setText("hh:mm:ss");
                    txtMoviePrice.setText("");
                    txtMovieTitle.requestFocus();
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setDelete(JTextField txtMovieTitle, JTextField txtMoviePrice, JTextField txtSearchId)
    {
        String id = txtSearchId.getText();

        if (id.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter movie ID.");
        else if (!id.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Movie ID must be a number.");
        else
        {
            try
            {
                // Check if movie ID exists
                pst = con.prepareStatement("select * from Movie where MovieID = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Movie ID " + id + " does not exist.");
                else
                {
                    // Check if movie ID exists in Schedule table
                    pst = con.prepareStatement("select MovieID from Schedule where MovieID = ?");
                    pst.setString(1, id);
                    rs = pst.executeQuery();

                    if (rs.next()) JOptionPane.showMessageDialog(null,
                                                                 "Movie ID " + id + " in Schedule Table must be deleted first.");
                    else
                    {
                        // Delete movie from Movie table
                        pst = con.prepareStatement("delete from Movie where MovieID = ?");
                        pst.setString(1, id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Movie ID " + id + " deleted successfully.");

                        txtSearchId.setText("");
                        txtMovieTitle.setText("");
                        txtMoviePrice.setText("");
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

    public void setUpdate(JTextField txtMovieTitle, JTextField txtMovieDuration, JTextField txtMoviePrice, JTextField txtSearchId, String category)
    {
        String id = txtSearchId.getText();
        String title = txtMovieTitle.getText();
        String price = txtMoviePrice.getText();
        String duration = txtMovieDuration.getText();

        if (id.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter movie ID.");
        else if (!id.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Movie ID must be a number.");
        else if (isValidTime(duration)) JOptionPane.showMessageDialog(null, "Enter a valid movie duration. (hh:mm:ss)");
        else if (title.isEmpty() || category.isEmpty() || price.isEmpty() || duration.isEmpty())
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!price.matches("[0.0-9]+") || Double.parseDouble(price) < 1.0)
            JOptionPane.showMessageDialog(null, "Price must be a number and at least 1.");
        else
        {
            try
            {
                // Check if movie ID exists
                pst = con.prepareStatement("select * from Movie where MovieID = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                if (!rs.next()) JOptionPane.showMessageDialog(null, "Movie ID " + id + " does not exist.");
                else
                {
                    // Update movie in Movie table
                    pst = con.prepareStatement(
                            "update Movie set MovieTitle = ?, MovieCategory = ?, MovieDuration = ?, MoviePrice = ? where MovieID = ?");
                    pst.setString(1, title);
                    pst.setString(2, category);
                    pst.setString(3, duration);
                    pst.setDouble(4, Double.parseDouble(price));
                    pst.setString(5, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Movie ID " + id + " updated successfully.");

                    txtSearchId.setText("");
                    txtMovieTitle.setText("");
                    txtMovieDuration.setText("hh:mm:ss");
                    txtMoviePrice.setText("");
                    txtSearchId.requestFocus();
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setSearch(JTextField txtMovieTitle, JTextField txtMovieCategory, JTextField txtMoviePrice, JTextField txtSearchId, JTextField txtMovieDuration)
    {
        String id = txtSearchId.getText();

        if (id.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter movie ID.");
        else if (!id.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Movie ID must be a number.");
        else
        {
            try
            {
                // Check if movie ID exists
                pst = con.prepareStatement("select * from Movie where MovieID = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Movie ID " + id + " does not exist.");
                else
                {
                    txtMovieTitle.setText(rs.getString("MovieTitle"));
                    txtMovieCategory.setText(rs.getString("MovieCategory"));
                    txtMovieDuration.setText(rs.getString("MovieDuration"));
                    txtMoviePrice.setText(String.valueOf(rs.getDouble("MoviePrice")));

                    JOptionPane.showMessageDialog(null, "Movie " + id + " found.");
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
