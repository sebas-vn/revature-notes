package com.revature;

import java.math.BigInteger;

public class Interruption {

	public static void main(String[] args) {
		
		// Here I will instantiate a thread by passing a runnable object to its constructor
		Thread compThread = new Thread(new LongComputationTask(new BigInteger("4"), new BigInteger("2")));
		
		compThread.start();
	
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		compThread.interrupt();
	}
	
	private static class LongComputationTask implements Runnable {

		private BigInteger base;
		private BigInteger power;
		
		public LongComputationTask(BigInteger base, BigInteger power) {
			super();
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			// thos will be the last step
			// we will print the result of a pow() method
			System.out.println(base + "^" + power + " = " + pow(base, power));
		}
		
		// method to calculate a num to a giver power
		private BigInteger pow(BigInteger base, BigInteger power) {
			BigInteger result = BigInteger.ONE;
			
			// 
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				
				if(Thread.currentThread().isInterrupted()) {
					System.out.println("Thread prematurely interrupted");
					return BigInteger.ZERO;
				}
				
				result = result.multiply(base);
			}
			
			return result;
		}
		
		
		
	}

}
