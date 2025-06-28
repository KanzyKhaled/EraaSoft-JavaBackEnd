package com.spring.core;

public class PersonService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("Saving user: " + name);
    }

    public void init() {
        System.out.println("PersonService initializing...");
    }

    public void destroy() {
        System.out.println("PersonService being destroyed...");
    }
}
