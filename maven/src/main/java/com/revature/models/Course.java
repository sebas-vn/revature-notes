package com.revature.models;

public class Course {
	
	public static final double costOfCourse = 600; // class scope
	
	private String name;
	
	public Course(String name) {
		super();
		this.name = name;
	}
	
	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	

}
