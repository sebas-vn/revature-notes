package com.revature.models;

// Our custim class inherits form the java.lang.Object
/**
 * 
 * 
 * This is a class! It is a template for an object!
 * You can only declare ONE public class per file
 * 
 * 
 * 
 * @author ron
 *
 */
public class Person {
	
	// STATIC means that this variable is accesible on class level... Person.MAX_AGE to call it
	public static int MAX_AGE = 115;
	
	// Instance variables (notice that they are NOT static)
	private String name;
	private int age;
	private double height;
	private double weight;
	
	public Person() {
		// this is a no-args constructor ()
	}
	
	public Person(String name) {
		super(); // super() calls the parent constructor. (In this case it's object)
		this.name = name;
	}
	
	
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public double calculateBMI() {
		return (this.weight / this.height / this.height) * 703;
	}

	// getters & setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	// Here we are overriding a method that we inherit from the Object class
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
	
}
