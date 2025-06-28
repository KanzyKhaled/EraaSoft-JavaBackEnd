package main;

public class Task2 implements Runnable  {

	private int id;
	private String name; 
	
	@Override
	public void run() {
		System.out.println("Current Thread Name is : " + Thread.currentThread().getName());
	}



}
