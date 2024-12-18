package org.jash.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.jash.component.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@SpringBootApplication
@ComponentScan({"org.jash.component"})
@Service
@Component
@Repository
@C
public class SpringbootFrameworkApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootFrameworkApplication.class, args);
		Student student = context.getBean(Student.class);
		student.print();
	}

}
