package com.prajwal.springboottut.AOPdemo9;

import com.prajwal.springboottut.AOPdemo9.dao.AccountDAO;
import com.prajwal.springboottut.AOPdemo9.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AOPdemo9Application {

	public static void main(String[] args) {
		SpringApplication.run(AOPdemo9Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO, TrafficFortuneService trafficFortuneService){

		return  runnner->{

			System.out.println("[INITIALIZING.....]");
			System.out.println("-----------------------------------------------------------");

//			demoTheBeforeAdvice(accountDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);


//			demoTheAround(trafficFortuneService);
			demoTheAroundHandle(trafficFortuneService);



		};
	}

	private void demoTheAroundHandle(TrafficFortuneService trafficFortuneService) {


		System.out.println("calling fortune service with handle exception");
		boolean flag=false;
		String f=trafficFortuneService.getFortune(flag);
		System.out.println("fortune="+f);

	}

	private void demoTheAround(TrafficFortuneService trafficFortuneService) {

		System.out.println("calling fortune service");
		String f=trafficFortuneService.getFortune();
		System.out.println("fortune="+f);
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {

		List<Account>accounts;
		try {

			accounts	= accountDAO.findAll(!false);
			System.out.println(accounts);

		}catch (Exception e){
			System.out.println( "In main :"+e.toString());
		}
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account>accounts;
		try {

			accounts	= accountDAO.findAll(false);
			System.out.println(accounts);

		}catch (Exception e){
			System.out.println( "In main :"+e.toString());
		}
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
