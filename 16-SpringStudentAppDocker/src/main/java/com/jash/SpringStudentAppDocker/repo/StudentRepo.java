package com.jash.SpringStudentAppDocker.repo;

import com.jash.SpringStudentAppDocker.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
