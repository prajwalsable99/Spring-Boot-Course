package com.prajwal.springboottut.AOPdemo;

import com.prajwal.springboottut.AOPdemo.dao.AccountDAO;
import com.prajwal.springboottut.AOPdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AOPdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AOPdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO,MembershipDAO membershipDAO){

		return  runnner->{

			System.out.println("[INITIALIZING.....]");
			System.out.println("-----------------------------------------------------------");

			demoTheBeforeAdvice(accountDAO,membershipDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		Account account=new Account("prajwal","lev-5");

		accountDAO.addAccount();
		System.out.println("-----------------------------------------------------------");
		accountDAO.addFakeAccount();
		System.out.println("-----------------------------------------------------------");
		membershipDAO.addAccount();
		System.out.println("-----------------------------------------------------------");
		accountDAO.addAccount(account);
		System.out.println("-----------------------------------------------------------");
		accountDAO.addAccount(account,true);
		System.out.println("-----------------------------------------------------------");
	}

}
