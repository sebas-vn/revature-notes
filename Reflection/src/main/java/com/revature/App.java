package com.revature;

import java.lang.reflect.Proxy;

import com.something.Adult;
import com.something.Person;

public class App {

	public static void main(String[] args) {
		
		Adult a1 = new Adult("Arnold", 30, "Innsbruck", "Austria");
		
		// I wanto to modify the method at runtime 
		// But I can't beacouse it's not my code
		//a1.introduce();
		
		/**
		 * Reflection API is used to examine or modify the behavior of classes/methods/interfaces at runtime
		 */
		
		// Get a classLoader from the original object that we want to create a proxy for
		ClassLoader a1ClassLoader = a1.getClass().getClassLoader();
		
		// capture all the interfaces that the original object implements 
		Class[] interfaces = a1.getClass().getInterfaces();
		
		// Create a proxy for our Adul Object
		Person proxyA1 = (Person) Proxy.newProxyInstance(a1ClassLoader, interfaces, new PersonInvocationHandler(a1));
		
		proxyA1.introduce();
		
		ClassInspector.listDeclaredMethods(Adult.class);
		
	}

}
