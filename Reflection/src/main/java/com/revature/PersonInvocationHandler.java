package com.revature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.something.Person;

public class PersonInvocationHandler implements InvocationHandler{
	
	private Person person;
	
	// a constrcutor for the proxy object 
	public PersonInvocationHandler(Person person) {
		super();
		this.person = person;
	}

	
	// Using this method, we can modify the behavior of the class using reflection
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		// adding functionality and still invoking the original method
		System.out.println("Hello!");
		
		return method.invoke(person);
		// the invoke() method has access to the originally invoked method and all its arguments
	}

}
