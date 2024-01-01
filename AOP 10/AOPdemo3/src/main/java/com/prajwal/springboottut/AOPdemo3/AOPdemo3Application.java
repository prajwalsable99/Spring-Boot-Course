package com.prajwal.springboottut.AOPdemo3;

import com.prajwal.springboottut.AOPdemo3.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AOPdemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(AOPdemo3Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO){

		return  runnner->{

			System.out.println("[INITIALIZING.....]");
			System.out.println("-----------------------------------------------------------");

			demoTheBeforeAdvice(accountDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {

		Account account=new Account("prajwal","lev-5");

		accountDAO.addAccount();
		System.out.println("-----------------------------------------------------------");
		accountDAO.addFakeAccount();
		System.out.println("-----------------------------------------------------------");
		accountDAO.addAccount(account);
		System.out.println("-----------------------------------------------------------");
		accountDAO.addAccount(account,true);
		System.out.println("-----------------------------------------------------------");



//		System.out.println("-----------------------------------------------------------");

	}

}
