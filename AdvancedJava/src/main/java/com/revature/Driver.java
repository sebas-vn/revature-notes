package com.revature;

public class Driver {

	public static void main(String[] args) {
		
		// 1 way to create a thread is by passing through a runnable object
		Thread classyThread = new Thread(new MyThread());
		
		classyThread.start();
		
		// Create a thread with an anonymous class 
		Thread anonThread = new Thread(new Runnable() {

			public void run() {
				System.out.println("Running from a thread");
				
			}
			
		});
		
		anonThread.start();
		
		// Create a thread with lambda (introduce in Java 8 for code readability)
		Thread lambdaThread = new Thread(() -> System.out.println("Running from the lambda thread"));
		
		lambdaThread.start();
		
		new Thread(() -> {
			int x = 100;
			
			System.out.println("Printing from a multi");
			System.out.println("line");
			System.out.println("thread created with a lambda");

		}).start();;
		
		System.out.println("End of main method and thread");

	}

}

// 1st way to create a thread is to create a class that implements Runnable interface
class MyThread implements Runnable {

	// Runnable is a functional interface
	public void run() {
		
		int sum = UtilityMethods.add(10, 90);	
		
		System.out.println("MyThread is running!");																																		
		
		System.out.println("The sum of the add method is" + sum);
		
	}
	
}

class UtilityMethods {
	public static int add(int x, int y) {
		return x + y;
	}
}