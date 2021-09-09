package com.revature.accessmods;

public class Driver2 {

	// we'll set fields of this class equal to the value of a Drive1 object
	
	Driver1 d1 = new Driver1();
	
	int y = d1.publicField;
//	int x = d1.privateField;
	int z = d1.protectedField;
	int w = d1.defaultField;
}
