package electricity.billing.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    Connection connection;

    Statement statement;

    database() {
        try {
            // Explicitly load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // its all things to provide like localhost, link, password etc to connect the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bill_system", "root", "HR2006@Rai");
            statement = connection.createStatement();
            System.out.println("Database connected successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            // it si hep to print exception in detail
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
