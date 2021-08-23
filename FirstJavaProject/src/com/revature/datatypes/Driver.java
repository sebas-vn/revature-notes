package com.revature.datatypes;

public class Driver {

	/**
	 * What is the purpose of the main method?
	 * 
	 * The main() method is where the JIT compiler begins program
	 * execution. The JIT compiler is a part of the JVM
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		
		// 8 Primitive datatypes
		
		boolean isCool = true; // 1 bit of reserved memory - 1 or 0
		byte reallySmallNumber = 127; // 8 bits of reserved memory
		short shortNumber = 32467; // 16 bits of reserved memory
		char letter = 'm'; // 16 bits of mem that represent an ASCII character
		
		int standardNum = 100; // 32 bits of mem
		float lessPreciseDecimal = 93.2f; // 32 bits of mem
		double decimal = 145.65; // 64 bits of mem allows you to make decimal numbers
		long veryLargeNum = 12345L; // 64 bits of mem
		
		// Since Java 7 you can use an _ for readability of your code:
		
		long creditCardNumber = 1234_5678_8912_1232L;
		int secondsInADay = 86_400;
		
		int x = 4;
		int y = 10;
		
		System.out.println(x + y);
		
		// a String is not a primitive data type. It is technically a flag
		String name = "Spongebob";
		
		// Casting
		
		byte a = 40;
		short b = a; // we have transformed a byte into a short
		int c = b;
		double d = c; // this works because we are doing something called Widening
		
		// Widening is when we transform a small datatype into a large datatype
		// This is one type of casting
		
		// a double is larger than an integer
		double dub = 900.9;
		int myInt = (int) dub; // we are using NARROW casting to transform a large datatype to a smaller one
		
		System.out.println("the double that has been explicitly cast into an int is now equal to " + myInt);
		
		// Everything above that has been defined are Java Literals, which are simply hard-coded fixed values that we assign to a variable
		
	}
}
