package com.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserService personService() {
        return new PersonService();
    }

    @Bean
    public AccountService accountService() {
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setUserService(personService());
        return accountService;
    }
}
