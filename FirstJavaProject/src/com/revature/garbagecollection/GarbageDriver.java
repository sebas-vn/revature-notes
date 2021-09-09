package com.revature.garbagecollection;

public class GarbageDriver {
	
	/**
	 * Final:
	 * 
	 * variable: never change the variable or the reference
	 * method: never override the method
	 * class: never extend the class
	 * @param args
	 */

	public static void main(String[] args) {
		
		System.out.println("Instantiating GarbageDriver object...");
		
		GarbageDriver gd = new GarbageDriver();
		// Currently the gd reference variable exists in the stack, and the object that we just created is in the heap
		
		System.out.println("GarbageDriver object successfully created");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally block is running");
		}
		gd = null;
		
		/**
		 * Garbage Collection is nondeterministic meaning that we can encourage it, but never fully guarantee it memory cleaning
		 */
		
		/**
		 * Every object that extends the java.lang.Object class has a special method called finalize()
		 * 
		 * when a object's finalize method is called, the object is removed from the heap
		 */
		
		System.gc();
		
		for (;;) {
			System.out.println("...");
		}

	}
	
	@Override
	protected void finalize() {
		System.out.println("GarbageDriver's finalize method has been called");
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("*********************************");
		
		System.out.println("Goodbye!");
		
		System.exit(0);
	}

}
