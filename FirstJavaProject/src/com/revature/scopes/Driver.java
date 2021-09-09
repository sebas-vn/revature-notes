package com.revature.scopes;

/**
 * In Java there are 4 scopes
 * 
 * 1. Class Scope(Static/Global scope)
 * 2. Instance Scope (these are varianles that belong to an object only)
 * 3. Method SCope
 * @author ron
 *
 */

public class Driver {
	
	public static void main(String[] args) {
		
		// where we will instantiate MyClass objects
		MyClass mcObj = new MyClass();
		
		int x = MyClass.myStaticVar;
		double z = mcObj.myInstanceVar;
		
		// static int j = 8; // CANNOT declare static variables inside of a method
		
		
		// declare a variable in the method scope
		int b = 5;
		
		while(b > 0) {
			// declaring a variable within a block scope
			int result = b * b;
			System.out.println(result);
			b--;
		}
		
		// you CAN'T access a block scoped variable from outside of the block
		// System.out.println(result);
	}
	
	public void anotherMethod() {
		int y = MyClass.myStaticVar;
		
		// you can't access another methods variable's within another method
	}

}
