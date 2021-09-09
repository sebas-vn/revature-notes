package com.revature.serialization;

public class Driver {
	public static void main(String[] args) {
		
		PetStore petco = new PetStore();
		PetStore petsmart = new PetStore();
		
//		// 2 ways to add a Pet object to petco's petFB
//		
//		// 1) First we instantiate the object, then we add it to the collection
//		Pet p1 = new Pet("Finn", 1004, "Cat", "Jerry", 4, Color.GREY);
//		
//		petco.petDB.add(p1);
//		
//		// 2) immediately call the collection and add AND instantiate the object at the same time
//		petco.petDB.add(new Pet("Spot", 3002, "Dog", "Larry", 10, Color.BROWN));
//		
//		System.out.println("Below is our ArrayList of Pets from the petco PETDB");
//		System.out.println(petco.petDB);
//		// serialize my entire petco object
//		petco.serialize();
		petsmart.deserialize();
		
		for (Pet newPet : petsmart.getPetDB()) {
			System.out.println("Deserialized pet");
			System.out.println(newPet);
		}
	}
}
