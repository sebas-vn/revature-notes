package com.revature.strings;

public class Driver {
	
	public static void main(String[] args) {
		
		/**
		 * Strings are used to store a sequence of characters but they're treated as objects
		 * because they come from the string class
		 * 
		 * - (1). String Object created with the new keyword -> goes to the general heap
		 * - (2). String Literal created with "some sentance" -> goes to the String Pool INSIDE the heap
		 */
		
		String stringObjects = new String("Straight to the general heap we go");
		
		
		String stringLiteral = "Straight to the string pool we go";
		
		
		String str1 = "Hello"; // JVM creates an object in the string pool
		
		String str2 = "Hello"; // the JVM is checking does this same string Object already exist in the string pool?
		
		// .equals() checks for value... do they have the same value
		System.out.println("Does str1 have the same value as str2" + str1.equals(str2));
		
		// do they point to the same location in memory
		System.out.println("Does str1 have the same value as str2" + (str1 == str2));
		
		
		
		String str5 = "Hello";
		String st6 = str5 + " World";
		
		String str6InPool = st6.intern();
		
		/**
		 * The String API
		 * 
		 * Methods to perform operations on strings
		 */
		
		String newStrObject = str6InPool.concat("somthing");
		
		String test = "The brown fox jumped over the lazy dog";
		
		String chopped = test.substring(5);
		
		System.out.println(chopped); // returns that part of the string literal as an object
		
		/**
		 * indexOf()
		 * charAt()
		 * split()
		 * length()
		 * isEmpty()
		 */
		
		// StringBuffer and StringBuilder are mutable versions of the String Class
		// StringBuffer is threadsafe and slower than stringbuilder
		
		StringBuilder sBuilder = new StringBuilder("Hello");
		
		sBuilder.append(" ");
		sBuilder.append("World"); // Modifying the same object! Can't do this with regular String objects...
		
		System.out.println(sBuilder);
		
		// you can take this StringBuilder object and send it to the String Pool
		String myString = sBuilder.toString(); // its sent OUTside of the string pool
	}

}
