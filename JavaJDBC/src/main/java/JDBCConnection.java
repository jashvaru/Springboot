import dao.DataDao;
import db.PostgresConnection;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) {
        System.out.println("Hello world");
        DataDao dataDao = new DataDao();
        /*String name = dataDao.getStudentName();
        System.out.println("Student name is " + name);*/
        /*dataDao.printAllRows();*/
        dataDao.insertData(4, "jasmine", 52);
        dataDao.printAllRows();
    }
}
