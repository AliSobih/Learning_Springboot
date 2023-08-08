package com.learningspringboot.cruddemo;

import com.learningspringboot.cruddemo.dao.AppDAO;
import com.learningspringboot.cruddemo.entity.Instructor;
import com.learningspringboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			saveInstructor(appDAO);
			findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}
	public void saveInstructor(AppDAO appDAO){
		InstructorDetail instructorDetail =
				new InstructorDetail("www.youtube.com","play");
		Instructor instructor=
				new Instructor("ali","fathy","alifathy@gmail.com");
		instructor.setInstructorDetail(instructorDetail);
		System.out.println("saving");
		appDAO.save(instructor);
	}
	public void findInstructor(AppDAO appDAO){
		 int id= 3;
		System.out.println(appDAO.findInstructorById(id));
	}
	public void deleteInstructor(AppDAO appDAO){
		int id = 2;
		appDAO.deleteInstructorById(id);
		System.out.println("Done!");
	}


}
