package com.revature.abstraction;

public abstract class Animals {
	
	/**
	 * An abstract class CANNOT be instantiated
	 */
	
	private int legs;
	private String color;
	
	public Animals() {
		System.out.println("Animal constructor is called");
	}
	
	// abstract methods are methods that have no body and are meant to be inherited and implemented
	public abstract void makeSound();
	
	public void exist() {
		System.out.println("The animal is existing");
	}

}
