package com.jash.SpringStudentAppDocker.service;

import com.jash.SpringStudentAppDocker.model.Student;
import com.jash.SpringStudentAppDocker.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
