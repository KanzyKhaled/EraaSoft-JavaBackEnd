package main;

public class Task1 extends Thread{

	private int id;
	private String name;
	
	@Override
	public void run() {
		System.out.println("Hello from thread");
	}
}
