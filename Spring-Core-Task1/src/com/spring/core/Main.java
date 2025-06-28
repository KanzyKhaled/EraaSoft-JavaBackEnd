package com.spring.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext applicationContext1 = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PersonService personService = 
				applicationContext1.getBean("personService", PersonService.class);
		
		personService.update("Ahmed");
		personService.save("Ahmed");
		
		ManagerService managerService = 
				applicationContext1.getBean("managerService", ManagerService.class);
		
		managerService.update("Mohamed");
		managerService.save("Mohamed");
		
		
		
		 ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(AppConfig.class);

	        UserService person = applicationContext2.getBean("personService", UserService.class);
	        UserService manager = applicationContext2.getBean("managerService", UserService.class);
	        
	        person.update("Omar");
	        person.save("Omar");
	       
	        manager.update("Amr");
	        manager.save("Amr");

	
		

	}

}
