package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PetStore {
	
	// every pet store has a db
	// here we'll first instantiate an arraylist and infer that it will hold pet objects\
	private ArrayList<Pet> petDB = new ArrayList<Pet>(); 
	
	//serialize()
	public void serialize() {
		
		// we're writing to a file. We need to use the Java.io package
		
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/pet.db"))) {
			
			// this is the code to execute
			oos.writeObject(this.getPetDB());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// deserialize()
	@SuppressWarnings("unchecked")
	public void deserialize() {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/pet.db"))) {
			
		// when a pet store object calls this method, it will call it on its petDB array
			this.setPetDB((ArrayList<Pet>) ois.readObject());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ArrayList<Pet> getPetDB() {
		return petDB;
	}


	public void setPetDB(ArrayList<Pet> petDB) {
		this.petDB = petDB;
	}
}
