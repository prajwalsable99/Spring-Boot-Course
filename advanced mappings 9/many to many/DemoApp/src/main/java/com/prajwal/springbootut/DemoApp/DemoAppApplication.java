package com.prajwal.springbootut.DemoApp;

import com.prajwal.springbootut.DemoApp.dao.AppDAO;
import com.prajwal.springbootut.DemoApp.entity.*;
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

//			deleteCourse(appDAO);


//		createCourseAndReviews(appDAO);


//			retrieveCourseAndReviews(appDAO);

//			deleteCourseAndReviews(appDAO);


//			createCourseAndStudents(appDAO);


//			findCourseAndStudents(appDAO);

//			findStudentsAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);


//			deleteCourse(appDAO);


			deleteStudent(appDAO);









		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id=1;
		appDAO.deleteStudentById(1);
		System.out.println("deleted");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id=2;
		Student student=appDAO.findStudentAndCoursesByStudentId(2);

		Course course=new Course("DSA");
		Course course2=new Course("OOPs");

		student.addCourses(course);
		student.addCourses(course2);

		appDAO.update(student);

		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findStudentsAndCourses(AppDAO appDAO) {

		int sid=1;
		Student student=appDAO.findStudentAndCoursesByStudentId(sid);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int cid=10;
		Course c=appDAO.findCourseAndStudentByCourseId(cid);

		System.out.println(c);
		System.out.println(c.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course1=new Course("english");
		Course course2=new Course("marathi");


		Student student1=new Student("prajwal","sable","ps@gmail.com");
		Student student2=new Student("vedant","kohle","vk@gmail.com");
		Student student3=new Student("atharva","mohite","am@gmail.com");
		course1.addStudent(student1);
		course1.addStudent(student2);
		course1.addStudent(student3);
		appDAO.save(course1);
//







	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id=10;

		appDAO.deleteCourseById(10);
		System.out.println("deleted");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id=10;
		Course c=appDAO.findCourseAndReviewsByCourseId(id);
		System.out.println(c);
		System.out.println(c.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course=new Course("DSA");

		Review review1=new Review("very good");
		Review review2=new Review("so good");
		course.addReview(review1);
		course.addReview(review2);

		appDAO.save(course);
		System.out.println("saved");
		System.out.println(course);
		System.out.println(course.getReviews());
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
