package com.revature.abstraction;

// Concrete classes
public class Frog extends Animals implements Ectothermic, Anfibious{

	@Override
	public void makeSound() {
		System.out.println("Ribbit");
		
	}
	
	public void makeSound(int times) {
		for (int i=0; i <=times; i++) {
			System.out.println("Ribbit...");
		}
	}

	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}

}
