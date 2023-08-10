package com.learningspringboot.cruddemo;

import com.learningspringboot.cruddemo.dao.AppDAO;
import com.learningspringboot.cruddemo.entity.Course;
import com.learningspringboot.cruddemo.entity.Instructor;
import com.learningspringboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.zip.CheckedOutputStream;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
//			saveInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorsWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCourses(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			appDAO.deleteInstructorById(1);
			deleteCourse(appDAO);
		};
		
	}

	private void deleteCourse(AppDAO appDAO) {
		System.out.println("starting");
		int id = 10;

		appDAO.deleteCourseById(id);
		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("starting........");
		Course course = appDAO.findCourseById(theId);
		course.setTitle("AI advanced");
		appDAO.update(course);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("update starting ");
		instructor.setFirstName("mohamed");
		appDAO.update(instructor);

		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(1);
		System.out.println("start");
		System.out.println(instructor);
		System.out.println("--------------");
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id=1;
		Instructor instructor = appDAO.findInstructorById(id);
		InstructorDetail instructorDetail=
				appDAO.findInstructorDetailById(id);
		List<Course> courseList = appDAO.findCoursesByInstructorId(id);

		System.out.println(instructor);
		System.out.println("---------------");
		System.out.println(instructorDetail);
		System.out.println("---------------");
		System.out.println(courseList);
	}

	private void createInstructorsWithCourses(AppDAO appDAO) {

		InstructorDetail instructorDetail =
				new InstructorDetail("www.youtube.com","play");
		Instructor instructor=
				new Instructor("ali","fathy","alifathy@gmail.com");
		instructor.setInstructorDetail(instructorDetail);
		Course course1 = new Course("AI");
		Course course2 = new Course("spring boot");
		instructor.add(course1);
		instructor.add(course2);
		appDAO.save(instructor);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id=3;
		InstructorDetail instructorDetail=
				appDAO.findInstructorDetailById(id);

			System.out.println(instructorDetail);
			System.out.println("---------------");
			System.out.println(instructorDetail.getInstructor());

	}

	public void deleteInstructorDetail(AppDAO appDAO){
		int id = 5;
		appDAO.deleteInstructorById(id);
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
