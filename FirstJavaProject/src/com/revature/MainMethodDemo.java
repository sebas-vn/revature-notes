package com.revature;

import java.util.Iterator;

public class MainMethodDemo {

	// This is where the JVM's JIT Compiler searches for the main() method
	
	/**
	 * This is where the JVM's JIT Compiler searches for the main() method
	 * @param args
	 * 
	 * args is an array of commands that could follow the execution command
	 */
	public static void main(String[] args) {
		
		System.out.println("Testing 123");
		
		for (String i: args) {
			System.out.println(i);
		}
		
		try {
			System.out.println(args[2]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough arguments");
		}
		
			
	}

}
