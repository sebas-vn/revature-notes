package com.revature.abstraction;

public class Cat extends Animals{
	
	// thanks to abstraction, all # of legs and color properties are abstracted
	private String breed;
	private boolean hasFur;
	

	@Override
	public void makeSound() {
		System.out.println("Meow");
	}
	
	public Cat() {
		super();
		this.hasFur = true;
	}


	// getters & setters
	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public boolean isHasFur() {
		return hasFur;
	}


	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	@Override
	public String toString() {
		return "Cat [breed=" + breed + ", hasFur=" + hasFur + "]";
	}
	

}
