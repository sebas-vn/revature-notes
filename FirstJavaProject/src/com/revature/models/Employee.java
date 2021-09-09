package com.revature.models;

import java.util.Objects;

/**
 * A Java Bean IS a type of POJO, but more specific and specialized
 * 
 * -- it's serializable
 * -- have getters/setters
 * 
 * @author ron
 *
 */
public class Employee extends Person{
	
	// all the properties of person are present in Employee but abstracted away from us
	
	private String dept;

	public Employee(String name, int age, double height, double weight, String dept) {
		super(name, age, height, weight);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + " dept =" + dept;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept); // this began in Java version 7
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dept, other.dept);
	}
	
	
	

}
