package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.revature.model.Employee;

public class ComparatorDriver {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee zayn = new Employee("Zayn Smith", 40);
		Employee mary = new Employee("Mary Shelly", 60);
		Employee abby = new Employee("Abby McCormick", 30);
		Employee xavier = new Employee("Xavier Hall", 25);
		
		employees.add(zayn);
		employees.add(mary);
		employees.add(abby);
		employees.add(xavier);
		
		// When we call forEach() we need to specify the functionality for the Consumer Interface's accept() method
		employees.forEach((e) -> System.out.println(e) );
		
		// Remember that cinsumer comes from the java.util.funtion oackage which  is where a lot of functional interfaces come from
		
		// this is a comparable object
		NameSorter ns = new NameSorter();
		
		Collections.sort(employees, ns);
		
		employees.forEach((e) -> System.out.println(e));
		
		// call the Collections.sort and create a Comparator anonymous class to sort in descending order
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		
		// Challenge 2: call the Collections.sort() method and create a LAMBDA function to sort the employees by age in ASCENDING order
		Collections.sort(employees, (emp1, emp2) -> Integer.valueOf(emp1.getAge()).compareTo(Integer.valueOf(emp2.getAge())));

	}

}

class NameSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}
	
}
