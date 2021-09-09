package com.revature;

public class ThreadCreation {

	public static void main(String[] args) {
		// Implement the Runnable interface and pass it to a new Thread object constructor
		
		// Extends Thread class and pass it to a class

		
		Thread t1 = new NewThread();
		t1.start();
		
		t1.setPriority(Thread.MAX_PRIORITY);
		
		// This belongsa to the Main thread
		System.out.println("Hello from the main thread! It's name is " + Thread.currentThread().getName());
		
		// 2nd way to create a thread (anonymous class ... lambda to provide functionality of the run() method)
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Now we are in thread " + Thread.currentThread().getName());
			}
		});
		
		Thread t3 = new Thread(() -> System.out.println("Running from a lambda thread"));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.setName("Thread B");
		
		t2.start();
		
		/**
		 * Thread states:
		 * 
		 * - New
		 * - Runnable (its run() method has been implemented)
		 * - Running
		 * - Non-Runnable (Blocked)
		 * - Terminated
		 */
	}
	
	private static class NewThread extends Thread {
		public void run() {
			System.out.println("Hello from " + this.getName());
		}
	}

}
