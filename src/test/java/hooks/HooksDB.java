package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HooksDB {

    public static Connection connection;
    public static Statement statement;

    @Before("@db") // this will only run for scenarios tagged with @db
    public void setUpDB() {
        try {
            // Adjust with your DB details
            String url = "jdbc:postgresql://64.227.123.49:5432/prettierhomes";
            String username = "techprotester";
            String password = "myPassword";

            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            System.out.println("Database connection established.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not connect to database: " + e.getMessage());
        }
    }

    @After("@db")
    public void tearDownDB() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();

            System.out.println("Database connection closed.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not close database connection: " + e.getMessage());
        }
    }
}
