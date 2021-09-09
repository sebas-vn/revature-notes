package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 0;
		
		int result = divideTryCatch(x, y);
		
		System.out.println(result);
		
	}
	
	static int divide(int x, int y) {
		return (x / y);
		
	}
	
	
	// I want to safe-guard my code so that it doesn't crash. To handle exceptions you use try/catch blocks.
	static int divideTryCatch(int x, int y) {
		try {
			return x / y;
		} catch (ArithmeticException e) {
			// this block of code will run when encountered with an arithmetic exception
			System.out.println("You can't divide by 0");
			System.out.println(e.getStackTrace());
			return 0;
		} finally {
			// this block of code will ALWAYSexecute no matter what -- typically it is used to close resources
			System.out.println("In the finally block");
		}
	}
	
	static void createFileCheckedExceptionDemo(String path, String text) {
		
		// Checked exceptions always force 
		FileWriter writer;
		
		try {
			writer = new FileWriter(path, true);
			writer.write(text);
			writer.close();
		} catch (IOException e) { // This is a checked exception. 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
