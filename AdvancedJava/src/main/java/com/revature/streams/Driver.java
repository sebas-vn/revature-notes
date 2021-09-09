package com.revature.streams;

import java.util.Arrays;
import java.util.List;

public class Driver {
	/**
	 * Streams - Stream API was introduced in java 8
	 * It is used to process a collection of objects.
	 * 
	 * A stream is NOT a collection! It is a sequence of object references that support various
	 * methods that can be piplined to produce the desired result;
	 * 
	 * We use streams to take input from Collections, Arrays or I/O channels*
	 */
	public static void main(String[] args) {
		List<String> bingoNums = Arrays.asList(
				
				"D40", "D46", 
				"B12", "B6",
				"G32", "G37", "G21", "g36",
				"I13", "I12", "I3",
				"O72"
				);
		
		// List all of the numbers in column G
		
		// traditional way
		
		bingoNums.forEach(n -> {
			if(n.toUpperCase().startsWith("G")) {
				System.out.println(n);
			}
		});
		
		System.out.println("=======================================");
		
		bingoNums.stream().map(String::toUpperCase) // map applies a given function to each element 
		// here we are referencing the method from a specific class that we want to perform on each element
		
		// Method referencing Class::Method
		// String::toUpperCase
		.filter(s -> s.startsWith("G")) // only find the g numbers
		.sorted()
		.forEach(System.out::println);
		
	}
}
