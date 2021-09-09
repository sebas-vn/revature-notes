package com.revature;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {
	
	public static void main(String[] args) {
		Map<String, String> languages = new HashMap<String, String>();
		
		// use the .put() method to insert data into a map
		languages.put("Java", "Compiled high-level oriented plaftform");
		languages.put("Python", "OOP Language");
		languages.put("JavaScript", "Runs browser");
		
		/**
		 * The Map interface does NOT extend Iterable
		 * 
		 * - You cannot have duplcate keys
		 * - but you can duplicate values
		 * 
		 */
		
		languages.put("JavaScript", "Not Java");
		
		System.out.println("I like to program in Java which is " + languages.get("Java"));
		
		/**
		 * How to iterate over a Map
		 */
		
		for (String key : languages.keySet()) {
			System.out.println("The key is " + key);
		}
		
		           
		
		// how to iterate over both the keys and the value within that map
		for (Map.Entry<String, String> entry : languages.entrySet()) {
			System.out.println(entry);
		}

	}

}
