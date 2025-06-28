package com.spring.core;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService1 = (AccountService) applicationContext1.getBean("accountService");
        accountService1.getSavePerson("Kanzy");


        ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService accountService2 = applicationContext2.getBean(AccountService.class);
        accountService2.getSavePerson("Kanzy");

	}

}
