package com.example.springboottut.DemoApp3;

import com.example.springboottut.DemoApp3.dao.StudentDAO;
import com.example.springboottut.DemoApp3.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApp3Application {

	public static void main(String[] args) {

		SpringApplication.run(DemoApp3Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO ){
		 return runner->{
//			 createStudent(studentDAO);

//			 readStudent(studentDAO);
//			 printAllStudemts(studentDAO);

//			 printAllStudemtswithLname(studentDAO);

//			 updateStudent(studentDAO);

//				deleteStudent(studentDAO);

//			 deleteAllStudents(studentDAO);

		 };
	}



	private void createStudent(StudentDAO studentDAO){

		System.out.println("saving student");
		Student student =new Student("prajwal","sable","prajwal@gmail.com");
		System.out.println("saving student");
		studentDAO.save(student);

		System.out.println("savedStudent " +student.getId());

	}

	private void readStudent(StudentDAO studentDAO){

		Student s=studentDAO.findById(2);
		if(s!=null){
			System.out.println(s);
		}
	}

	private void printAllStudemts(StudentDAO studentDAO){

		List<Student> li=studentDAO.findAll();
		for (Student s :li){
			System.out.println(s);
		}
	}

	private void printAllStudemtswithLname(StudentDAO studentDAO){

		List<Student> li=studentDAO.findBylastName("sable");
		for (Student s :li){
			System.out.println(s);
		}
	}

	private void updateStudent(StudentDAO studentDAO){

		Student s=studentDAO.findById(3);
		s.setEmail("random@xyz.com");

		studentDAO.update(s);

		System.out.println(s);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		studentDAO.delete(3);
		System.out.println("deletd suceesdully");

	}

	private void deleteAllStudents(StudentDAO studentDAO){

		int x=studentDAO.deleteAll();
		System.out.println( x+ " students record removed");
	}

}
