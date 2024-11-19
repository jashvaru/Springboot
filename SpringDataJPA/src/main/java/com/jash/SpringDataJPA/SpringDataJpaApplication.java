package com.jash.SpringDataJPA;

import com.jash.SpringDataJPA.model.Student;
import com.jash.SpringDataJPA.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);
		StudentRepo studentRepo = context.getBean(StudentRepo.class);

		/*s1.setRollNo(1);
		s1.setName("J");
		s1.setMarks(10);

		s2.setRollNo(2);
		s2.setName("K");
		s2.setMarks(20);

		s3.setRollNo(3);
		s3.setName("L");
		s3.setMarks(30);

		studentRepo.save(s1);
		studentRepo.save(s2);
		studentRepo.save(s3);*/

		/*System.out.println(studentRepo.findAll())*/;
		/*System.out.println(studentRepo.findById(2));*/

		/*System.out.println(studentRepo.findByName("J"));*/

		System.out.println(studentRepo.findByMarks(30));
		System.out.println(studentRepo.findByMarksGreaterThan(11));

	}

}
