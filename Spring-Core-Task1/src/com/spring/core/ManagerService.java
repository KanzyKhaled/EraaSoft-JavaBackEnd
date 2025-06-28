package com.spring.core;

public class ManagerService implements UserService {

	public void save(String name) {
		// TODO Auto-generated method stub
		System.out.println("Manager " + name + " Saved" );
	}

	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		System.out.println("Manager " + name + " Updated");
	}

}

