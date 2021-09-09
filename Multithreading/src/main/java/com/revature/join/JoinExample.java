package com.revature.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinExample {
	
	public static void main(String[] args) throws InterruptedException {
		List<Long> inputNumbers = Arrays.asList(0L, 3535L, 35434L, 23L, 6655L);
		// we will want to calculate the factorials of each of these numbers
		
		// first, we buuild a data structire to collect some yet-to-be-new threads in
		List<FactorialThread> threads = new ArrayList<>();
		
		// for each number within the input number, pass it toe constrcutor of a newly
		// instantiated thread
		for (long num : inputNumbers) {
			threads.add(new FactorialThread(num));
		}
		
		for(Thread t : threads) {
			t.setDaemon(true);
			t.start();
		}
		
		for (Thread t : threads) {
			t.join(); // this may throw an InterruptedException
			/**
			 * join() is a synchronization method that blocks the calling thread until the thread is being called on completes
			 */
		}
		
		// check to see the result
		for(int i=0; i<inputNumbers.size(); i++) {
			FactorialThread factorialThread = threads.get(i); // O(1) retrieval
			
			if(factorialThread.isFinished()) {
				System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
			} else {
				System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress...");
			}
		}
		
		/**
		 * Here we have a race condition between the main thread and the factorial thread
		 * 
		 * In order to solve this, we must implement the join method so that the main method wil wait
		 */
	}
}
