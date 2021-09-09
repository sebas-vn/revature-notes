package com.revature.abstraction;

/**
 * Abstraction is the process of hiding certain details and showing only essential information to the user.
 * 
 * This is achieved with interfaces and abstract classes in Java. You can't instantiate either and abstract class OR an interface. 
 * @author ron
 *
 */

public class Driver {

	public static void main(String[] args) {
		// Animals is my reference type...
		Animals a1 = new Cat();
		
		// I can now reassign this variable to any other object whose class extends Animals
		
		a1 = new Frog();
	}

}
