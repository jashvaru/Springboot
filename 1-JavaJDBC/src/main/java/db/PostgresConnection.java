package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    public static Connection connection = null;

    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/java";
            String username = "postgres";
            String pass = "0000";

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, pass);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connection Successful");
        return connection;
    }

    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed Successful");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}