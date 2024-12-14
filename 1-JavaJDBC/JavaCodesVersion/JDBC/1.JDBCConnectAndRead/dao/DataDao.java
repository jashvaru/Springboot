package dao;

import db.PostgresConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataDao {

    public String getStudentName() {
        String studentName = new String();
        Connection con = PostgresConnection.getConnection();
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select sname from student where sid = 1");
            resultSet.next();
            studentName = resultSet.getString("sname");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PostgresConnection.closeConnection();
        return studentName;
    }
}
