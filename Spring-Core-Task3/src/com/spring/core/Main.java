package com.spring.core;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserService  accountService1 = (UserService ) applicationContext1.getBean("personService");
        accountService1.save("Kanzy");

        UserService  accountService2 = (UserService ) applicationContext1.getBean("personService");
        accountService2.save("Fatma");

        ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService person1 = applicationContext2.getBean("personService", UserService.class);
        person1.save("Habiba");

        UserService person2 = applicationContext2.getBean("personService", UserService.class);
        person2.save("Diana");

       


	}

}
