package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Course;

// This is a test suite (a grouping of unit tests for 1 specific class)
public class CourseTest {
	
	// create some dummy objects
	static Course c1; // here we just declare them, later we instantiate
	static Course c2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Running before all tests within test suite");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Running before all tests within test suite");
	}
	
	// something to execute before each test
	@Before
	public void setUp() {
		
		System.out.println("Setting up");
		
		c1 = new Course("English 101");
		c2 = new Course("Astrophysics 550");
	}
	
	@After	
	public void tearDown() {
		
		System.out.println("Tearing down");
		
		c1 = null;
		c2 = null;
	}
	
	@Test
	public void test() {
		System.out.println("I am a test");
	}
	
	// Test getName()
	@Test
	public void testGetName() {
		String expectedName = "English 101";
		
		String actualName = c1.getName();
		
		assertEquals(expectedName, actualName);
		
	}
	
	@Test
	public void testSetName() {
		
		String nameToSet = "History 402";
		c1.setName(nameToSet);
		
		assertTrue(c1.getName().equals(nameToSet));
	}
	
}