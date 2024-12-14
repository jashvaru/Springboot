package com.jash.JDBCEx.repo;

import com.jash.JDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Student student) {
        String sql = "insert into students (rollNo, name, marks) values (?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, student.getRollNo(), student.getName(), student.getMarks());
        System.out.println("student saved & No. of rows affected = " + rowsAffected);
    }

    public List<Student> findAll() {
        String sql = "select * from students";
        List<Student> studentList = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
                Student student = new Student();
                student.setRollNo(rs.getInt("rollNo"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getInt("marks"));
                return student;
            });
        System.out.println("students fetched");
        return studentList;
    }
}
