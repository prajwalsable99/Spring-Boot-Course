package com.prajwal.springboottut.demo.DemoApp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//to load external packages
//@SpringBootApplication(scanBasePackages = {" external packages name"})

@SpringBootApplication
public class DemoApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoApp2Application.class, args);
	}

}
