package com.revature.otherpackage;

import com.revature.accessmods.Driver1;

public class Driver3 extends Driver1{ // by extending we are inheriting the properties (fields) & behaviors of the parent Class
	
	Driver3 d3 = new Driver3();
	
	int i = publicField; // this already exists because we're inheriting it from Diver 1
	
	int k = d3.protectedField; // this field is inherited automatically from Driver1
	

}
