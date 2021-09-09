package com.revature.challenge;

import java.math.BigInteger;

/*
 * ===========================================================
 * =============== MultiThreaded Calculation =================
 * ===========================================================
 * In this coding exercise we will you all the knowledge from the 
 * previous lectures.Before taking the exercise make sure you review
 *  the following topics in particular:
 * 
 * 1. Thread Creation - how to create and start a thread using the Thread class and the start() method.
 *
 * 2. Thread Join - how to wait for another thread using the Thread.join() method.
 * 	                Remember: Remember that .join() tells the calling program to wait until the thread
					          object upon which the join method has been called has finished its work.
 * 
 * In this exercise we will efficiently calculate the following result = base1 ^ power1 + base2 ^ power2
 * Where a^b means: a raised to the power of b.
 *
 * For example 10^2 = 100
 * 
 * We know that raising a number to a power is a complex computation, so we we like to execute:
 * 
 * 			result1 = x1 ^ y1 
 * 
 * 			result2 = x2 ^ y2
 * 
 * In parallel, and combine the result in the end : result = result1 + result2
 * This way we can speed up the entire calculation.
 * 
 * NOTE: base1 >= 0, base2 >= 0, power1 >= 0, power2 >= 0
 * ===========================================================
 * ===========================================================
 */

/*
 * =================================
 * ========== Challenge ============
 * =================================
 */


public class MultiThreadedCalculationChallenge {
	
	public static void main(String[] args) {
		
	}

	public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {

		BigInteger result = BigInteger.ZERO; /* ! I'm only initializing this here so my compiler doens't yell at me.
											  * When presenting the challenge, it's fine to leave it un-initialized
											  * i.e ... BigInteger result; 
											  */
	
		PowerCalculatingThread t1 = new PowerCalculatingThread(base1, power1);
		PowerCalculatingThread t2 = new PowerCalculatingThread(base2, power2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Calculate result = ( base1 ^ power1 ) + (base2 ^ power2). Where each
		 * calculation in is calculated on a different thread.
		 */
		result = t1.getResult().add(t2.getResult());
 		return result;
	}

	private static class PowerCalculatingThread extends Thread {

		private BigInteger result = BigInteger.ONE;
		private BigInteger base;
		private BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			result = pow(base, power);
		}
		
		public BigInteger pow(BigInteger base, BigInteger power) {
			BigInteger result = BigInteger.ONE;
			
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Thread prematurely interrupted");
					return BigInteger.ZERO;
				}
				
				result = result.multiply(base);
			}
			
			return result;
		}

		public BigInteger getResult() {
			return result;
		}
	}
}