package com.jash.JDBCEx.service;

import com.jash.JDBCEx.model.Student;
import com.jash.JDBCEx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void saveStudent(Student student) {
        System.out.println("saveStudent method called");
        studentRepo.save(student);
    }

    public void fetchStudents() {
        System.out.println("fetchStudents method called");
        System.out.println(studentRepo.findAll());
    }
}
