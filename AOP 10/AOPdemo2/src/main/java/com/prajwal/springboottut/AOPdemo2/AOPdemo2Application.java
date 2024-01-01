package com.prajwal.springboottut.AOPdemo2;

import com.prajwal.springboottut.AOPdemo2.dao.AccountDAO;
import com.prajwal.springboottut.AOPdemo2.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AOPdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(AOPdemo2Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){

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

		accountDAO.setAccName("john");
		accountDAO.setAccCode("ABC124");
		accountDAO.getAccName();
		accountDAO.getAccCode();

		System.out.println("-----------------------------------------------------------");

	}

}
