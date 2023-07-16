package RackVisionCinema.Methods;

import java.sql.*;

public class Controller {
    public Controller() {
        try {
            // Load the MySQL driver to connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "123");

            // Validation message if connection is successful
            System.out.println("MySQL Connected.");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    // Database connection
    public Connection con;
    // Query statement
    public PreparedStatement pst;
}
