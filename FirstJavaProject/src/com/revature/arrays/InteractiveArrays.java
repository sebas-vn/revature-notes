package com.revature.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class InteractiveArrays {
	
	// static binds this field to the class scope
	private static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		int size = 5;
		
		int[] returnedArr = getIntegers(size);
		
		// you have to create the getAverage method
		double avg = getAverage(returnedArr);
		
		System.out.println(avg);
		
	}
	
	// step 1: Let's create a method that asks the user to create an 
	// array and input some custom values to populate the array
	static int[] getIntegers(int capacity) {
		
		System.out.println("Enter " + capacity + " integers");
		
		int[] values = new int[capacity];
		
		for(int i=0; i<values.length; i++) {
			
			values[i] = scan.nextInt();
		}		
		
		return values;
	}

	/*
	 * CHALLENGE:
	 * Create a static method that takes in an int array as a parameter.  It must return the average of all
	 * the elements within the array. (Make its return type a double).
	 * 
	 * Once you create this method, call it within the main method, and print its return, after passing through
	 * the array that returned by the getIntegers method.
	 */
	
	static double getAverage(int[] arr) {
		double sum = 0;
		for (int i: arr) {
			sum += i;
		}
		return sum / (double) arr.length;
	}

	
	// Bonus method
	
	static void printArray(int[] arr) {
		// void means that the method does not return anything
		
		System.out.println(Arrays.toString(arr));
	}
	
	
}
