package com.revature.models;

public class Driver {
	
	public static void main(String[] args) {
		
		// Can you instantiate an object from a class where you have NOT defined a constructor
		// A reference type is a "custom type". This is a User defined class
		
		Person p1 = new Person("Fred", 30, 64, 160.50);
		
		System.out.println(p1);
		System.out.println(p1.getName());
		
		Person p2 = new Person();
		
		System.out.println(Person.MAX_AGE); // Here we are invoking a static variable at the class level
		
		// p2.MAX_AGE = 44; // you can always alter a static variable for a particular object, but you can control this with the final keyword
		// System.out.println(p2.MAX_AGE = 40);
		
		System.out.println("Fred's BMI is " + p1.calculateBMI());
		
		// Below 2 separate objects are being instantiated
		Employee e1 = new Employee("Bob", 2, 3, 4, "Finance");
		Employee e2 = new Employee("Bob", 2, 3, 4, "Finance");
		
		
		// What if I want to put Employee objects inside of a data 
		
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
	}

}
