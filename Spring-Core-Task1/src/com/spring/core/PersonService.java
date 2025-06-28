package com.spring.core;

public class PersonService  implements UserService{

	@Override
	public void save(String name) {
		// TODO Auto-generated method stub
		System.out.println("Person " + name + " Saved" );
	}

	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		System.out.println("Person " + name + " Updated");
	}

}
