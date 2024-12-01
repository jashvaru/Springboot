package com.jash.SpringSecurity.controller;

import com.jash.SpringSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private final List<Student> studentList = new ArrayList<>(List.of(
            new Student(1, "Alice", "Java"),
            new Student(2, "Bob", "Python")
    ));

    @GetMapping("students")
    public List<Student> getStudents() {
        return studentList;
    }

    @PostMapping("student")
    public void addStudent(@RequestBody Student student) {
        studentList.add(student);
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
