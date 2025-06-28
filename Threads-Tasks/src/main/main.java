package main;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Task1 task1 = new Task1();
		task1.start();
		Task2 task2 = new Task2();
		Thread thread = new Thread(task2);

		thread.start();
		
		PrintNumbers printNumbers = new PrintNumbers();
		printNumbers.start();
		
		try {
			task1.join();
			printNumbers.join();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("End of Main Thread");
	}

}
