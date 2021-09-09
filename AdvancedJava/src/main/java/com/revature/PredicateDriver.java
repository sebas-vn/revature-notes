package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.model.Employee;

public class PredicateDriver {

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
		
		// first with anonymous class
		printEmployeesByAge(employees, "All employees under 50", new Predicate<Employee>() {

			@Override
			public boolean test(Employee e) {
				// TODO Auto-generated method stub
				return e.getAge() < 50;
			}
			
		});
		
		System.out.println("***************** - **************");
		
		// passing a predicate with a lambda 
		printEmployeesByAge(employees, "All employees over 30", (e) -> e.getAge() > 30);
		
		/**
		 * Primitive functional interfaces. Predefine Predicates for specific data types
		 */
		
		IntPredicate greaterThan15 = i -> i > 15;
		System.out.println("Is 10 greater than 15? : " + greaterThan15.test(10));
		
		
		System.out.println("========= Predicate Chaining =========");
		IntPredicate lessThan100 = i -> i < 100;
		System.out.println(greaterThan15.and(lessThan100).test(56));

	}
	
	private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
		// This represents the conditions by which we're sorting the employees by their age
		System.out.println(ageText);
		
		for (Employee e : employees) {
			if(ageCondition.test(e)) {
				System.out.println(e.getName() + " is " + e.getAge() + " years old");
			}
		}
		
	}

}
