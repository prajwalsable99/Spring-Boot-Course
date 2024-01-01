package com.prajwal.springbootut.DemoApp;

import com.prajwal.springbootut.DemoApp.dao.AppDAO;
import com.prajwal.springbootut.DemoApp.entity.Instructor;
import com.prajwal.springbootut.DemoApp.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

			deleteInstructor(appDAO);

		};
	}

	private void deleteInstructor(AppDAO appDAO) {

		int xid=2;
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
