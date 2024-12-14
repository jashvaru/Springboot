package dao;

import db.PostgresConnection;

import java.sql.*;

public class DataDao {

    public String getStudentName() {
        String studentName = new String();
        Connection con = PostgresConnection.getConnection(); //get the connection of the DB
        Statement statement = null; //It is the object that will be used to execute the static sql statement
        try {
            statement = con.createStatement(); //get the statement obj using the connection
            ResultSet resultSet = statement.executeQuery("select * from student where sid = 1"); //executeQuery method is used to run a single static SQL query
            resultSet.next(); //ResultSet holds the cursor pointing to current row. Initially it point before to first row thats why we need to do .next to get the first row of DB
            studentName = resultSet.getString("sname");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PostgresConnection.closeConnection();
        return studentName;
    }

    public void printAllRows() {
        Connection con = PostgresConnection.getConnection(); //get the connection of the DB
        Statement statement = null; //It is the object that will be used to execute the static sql statement
        try {
            statement = con.createStatement(); //get the statement obj using the connection
            ResultSet resultSet = statement.executeQuery("select * from student"); //executeQuery method is used to run a single static SQL query
            while (resultSet.next()) {
                System.out.println("%d - %s - %d".formatted(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PostgresConnection.closeConnection();

        /*
            Connection Successful
            1 - jash - 99
            2 - jay - 73
            3 - mohan - 30
            Connection closed Successful
        */
    }

    public void insertData(int id, String name, int marks) {
        Connection con = PostgresConnection.getConnection(); //get the connection of the DB
        try {
            String insertQuery = "insert into student values (?, ?, ?)";
            PreparedStatement prepareStatement = con.prepareStatement(insertQuery); //get the statement obj using the connection
            prepareStatement.setInt(1, id);
            prepareStatement.setString(2, name);
            prepareStatement.setInt(3, marks);
            prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PostgresConnection.closeConnection();
    }
}
