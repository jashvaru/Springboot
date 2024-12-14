package com.jash.JDBCEx;

import ch.qos.logback.core.net.server.Client;
import com.jash.JDBCEx.model.Student;
import com.jash.JDBCEx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcExApplication.class, args);
		System.out.println("Client Started");
		Student student = context.getBean(Student.class);
		student.setRollNo(101);
		student.setName("Jash");
		student.setMarks(99);
		System.out.println("Student = " + student);

		StudentService studentService = context.getBean(StudentService.class);
//		studentService.saveStudent(student);
		studentService.fetchStudents();
	}

}
