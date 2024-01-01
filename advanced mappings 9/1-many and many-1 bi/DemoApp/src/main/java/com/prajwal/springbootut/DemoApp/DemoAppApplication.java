package com.prajwal.springbootut.DemoApp;

import com.prajwal.springbootut.DemoApp.dao.AppDAO;
import com.prajwal.springbootut.DemoApp.entity.Course;
import com.prajwal.springbootut.DemoApp.entity.Instructor;
import com.prajwal.springbootut.DemoApp.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			System.out.println("[ APP STARTED !!! ]");

//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);
//
//------------------------------------------------------------------------------------
//			findInstructorDetail(appDAO);

//			deleteInstructorDetail(appDAO);

//-------------------------------------------------------------------------------------------
//			createInstructorwithCourses(appDAO);

//			findInstructorWithCourses(appDAO);

//			findInstructorWithCoursesLazy(appDAO);

//            updateInstructor(appDAO);

//			updateCourse(appDAO);

//		deleteInstructor(appDAO);  //again with course

			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int cid=10;

		appDAO.deleteCourseById(cid);
		System.out.println("deleted");
	}

	private void updateCourse(AppDAO appDAO) {
		int cid=11;
		Course c=appDAO.findCourseById(cid);
		c.setTitle("mathematics");
		appDAO.updateCourse(c);
		System.out.println("updated");
	}

	private void updateInstructor(AppDAO appDAO) {
        int idx=1;
        Instructor instructor=appDAO.findInstructorById(idx);
        instructor.setLastName("Doe");

        appDAO.updateInsructor(instructor);
        System.out.println("updated");

    }

    private void findInstructorWithCoursesLazy(AppDAO appDAO) {
		int idx=1;
		Instructor instructor=appDAO.findInstructorById(idx);


		List<Course>courses=appDAO.findCoursesByInstructorId(idx);

		instructor.setCourses(courses);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());

	}

	// eager fetching
	private void findInstructorWithCourses(AppDAO appDAO) {

		int idx=1;
		Instructor instructor=appDAO.findInstructorById(idx);

		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void createInstructorwithCourses(AppDAO appDAO) {

		Instructor instructor=new Instructor("Vedant","Kolhe","vk12@gmail.com");

		InstructorDetail instructorDetail=new InstructorDetail("vedGamer","reading");

		instructor.setInstructorDetail(instructorDetail);

		Course c1=new Course("physics");
		Course c2=new Course("maths");
		Course c3=new Course("chemistry");

		instructor.add(c1);
		instructor.add(c2);
		instructor.add(c3);





		//save both
		appDAO.save(instructor);


		System.out.println("added new inst with courses");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int idx=1;
		appDAO.deleteInstructorDetailById(idx);
		System.out.println("Deleted");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int xid=1;
		InstructorDetail instructorDetail=appDAO.findInstructorDetailById(xid);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {

		int xid=1;
		appDAO.deleteInstructorById(xid);
		System.out.println("[deleted]");
	}

	private void findInstructor(AppDAO appDAO) {

		int xid=1;
		Instructor instructor=appDAO.findInstructorById(xid);
		System.out.println("[founded]");
		System.out.println(instructor);
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor=new Instructor("Vedant","Kolhe","vk12@gmail.com");

		InstructorDetail instructorDetail=new InstructorDetail("vedGamer","reading");

		instructor.setInstructorDetail(instructorDetail);

		//save both
		appDAO.save(instructor);

		System.out.println("[SAVING !! ]");




	}

}
