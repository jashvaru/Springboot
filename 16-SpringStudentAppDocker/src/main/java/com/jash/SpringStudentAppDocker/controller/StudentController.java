package com.jash.SpringStudentAppDocker.controller;

import com.jash.SpringStudentAppDocker.model.Student;
import com.jash.SpringStudentAppDocker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students", produces = "application/json")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello Student Docker";
    }
}
