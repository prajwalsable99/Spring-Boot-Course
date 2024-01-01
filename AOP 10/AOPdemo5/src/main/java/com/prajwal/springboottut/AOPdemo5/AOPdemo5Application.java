package com.prajwal.springboottut.AOPdemo5;

import com.prajwal.springboottut.AOPdemo5.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AOPdemo5Application {

	public static void main(String[] args) {
		SpringApplication.run(AOPdemo5Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO){

		return  runnner->{

			System.out.println("[INITIALIZING.....]");
			System.out.println("-----------------------------------------------------------");

//			demoTheBeforeAdvice(accountDAO);
			demoTheAfterReturningAdvice(accountDAO);

		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

//
//			accountDAO.addFakeAccount();
//		System.out.println("---------------------------------------------");

		List<Account>accounts= accountDAO.findAll();


		System.out.println("---------------------------------------------");

		System.out.println("Final data returned");
		for(Account account:accounts){
			System.out.println(account);
		}
		System.out.println("---------------------------------------------");


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
