package RackVisionCinema.Methods;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Viewer extends Controller
{
    public void tableLoad(JTable viewerTable)
    {
        try
        {
            // Join Viewer and ViewerType tables to load ViewerType name and discount
            pst = con.prepareStatement(
                    "SELECT ViewerID, ViewerAge, TypeName, Discount FROM Viewer LEFT JOIN ViewerType ON ViewerType = TypeName;");
            ResultSet rs = pst.executeQuery();
            viewerTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setSave(JTextField txtViewerAge, String type)
    {
        String age = txtViewerAge.getText();

        if (age.isEmpty() || type.isEmpty()) JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!age.matches("[0-9]+") || Integer.parseInt(age) < 1)
            JOptionPane.showMessageDialog(null, "Age must be a number and at least 1 year.");
        else
        {
            try
            {
                // Validate viewer type
                pst = con.prepareStatement("insert into Viewer(ViewerAge, ViewerType) values(?, ?)");
                pst.setString(1, age);
                pst.setString(2, type);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Viewer added successfully.");

                txtViewerAge.setText("");
                txtViewerAge.requestFocus();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setSearch(JTextField txtSearchId, JTextField txtViewerAge)
    {
        String id = txtSearchId.getText();

        if (id.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter viewer ID.");
        else if (!id.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Viewer ID must be a number.");
        else
        {
            try
            {
                // Validate viewer id if exists
                pst = con.prepareStatement("select * from Viewer where ViewerID = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Viewer ID " + id + " does not exist.");
                else
                {
                    String age = rs.getString("ViewerAge");
                    txtViewerAge.setText(age);

                    JOptionPane.showMessageDialog(null, "Viewer ID " + id + " found.");
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setUpdate(JTextField txtSearchId, JTextField txtViewerAge, String type)
    {
        String id = txtSearchId.getText();
        String age = txtViewerAge.getText();

        if (id.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter viewer ID.");
        else if (age.isEmpty() || type.isEmpty()) JOptionPane.showMessageDialog(null, "Please fill all fields.");
        else if (!id.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Viewer ID must be a number.");
        else if (!age.matches("[0-9]+") || Integer.parseInt(age) < 1)
            JOptionPane.showMessageDialog(null, "Age must be a number and at least 1 year.");
        else
        {
            try
            {
                // Validate viewer id if exists
                pst = con.prepareStatement("SELECT * FROM Viewer WHERE ViewerID = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Viewer ID " + id + " does not exist.");
                else
                {
                    // Update viewer
                    pst = con.prepareStatement("UPDATE Viewer SET ViewerAge = ?, ViewerType = ? WHERE ViewerID = ?");
                    pst.setString(1, age);
                    pst.setString(2, type);
                    pst.setString(3, id);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Viewer updated successfully.");

                    txtSearchId.setText("");
                    txtViewerAge.setText("");
                    txtSearchId.requestFocus();
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void setDelete(JTextField txtSearchId)
    {
        String id = txtSearchId.getText();

        if (id.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter viewer ID.");
        else if (!id.matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Viewer ID must be a number.");
        else
        {
            try
            {
                // Check if viewer ID exists
                pst = con.prepareStatement("select * from Viewer where ViewerID = ?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();

                if (!rs.next()) JOptionPane.showMessageDialog(null, "Viewer ID " + id + " does not exist.");
                else
                {
                    // Check if viewer ID exists in Ticket table
                    pst = con.prepareStatement("select ViewerID from Ticket where ViewerID = ?");
                    pst.setString(1, id);
                    rs = pst.executeQuery();

                    if (rs.next()) JOptionPane.showMessageDialog(null,
                                                                 "Viewer ID " + id + " in Ticket Table must be deleted first.");
                    else
                    {
                        // Delete viewer
                        pst = con.prepareStatement("delete from Viewer where ViewerID = ?");
                        pst.setString(1, id);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Viewer ID " + id + " deleted successfully.");

                        txtSearchId.setText("");
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
