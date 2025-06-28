package com.spring.core;

public class AccountServiceImpl implements AccountService {
    private UserService userService;

   
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void getSavePerson(String name) {
        System.out.println("AccountServiceImpl: Delegating save to PersonService...");
        userService.save(name);
    }
}

