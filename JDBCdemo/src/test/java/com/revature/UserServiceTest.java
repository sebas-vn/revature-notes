package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exceptions.RegisterUserFailedException;
import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.services.UserService;

public class UserServiceTest {
	
	// declare the class to be tested
	private UserService uservice;
	
	// declare the dependencies of the userservice
	// We will be using mockito to "mock" the dao layer, that the UserService is dependent on
	private UserDao mockdao;
	
	User dummyUser;
	
	@Before // before every test is run
	public void setup() {
		uservice = new UserService();
		
		// mock the dependecny provided that's provided to the user service
		mockdao = mock(UserDao.class); // shell instance of a class
		
		// every userService has a DAO that it relied on...
		uservice.udao = mockdao;
		
		// this is a stub
		dummyUser = new User();
		dummyUser.setAccounts(new ArrayList<Account>());
		dummyUser.setId(0);
	}
	
	@After // after each unir test runs
	public void tearDown() {
		uservice = null;
		dummyUser = null;
		mockdao = null;
	}
	
	// Whenerever we insert a user, it returns a valid primary key
	// if it were NOT returning the right key, we'd have some major problems
	
	@Test
	public void testRegisterUSer_returnsNewPk() {
		dummyUser = new User(0, "spongebob", "pineapple", Role.Admin, new ArrayList<>());
		
		// Generate a hard coded random primary number that will be returned by the mockdao's insert method
		Random r = new Random();
		int fakePk = r.nextInt(100);
		
		// Here we are intercepting the UserService's call to the DAO layer
		when(mockdao.insert(dummyUser)).thenReturn(fakePk); // this user should never be inserted in our database
		
		// Here we're testing does the register method properly call our dao layer
		User registeredUser = uservice.register(dummyUser);
		assertEquals(registeredUser.getId(), fakePk);
	}
	
	@Test(expected=RegisterUserFailedException.class)
	public void testRegister_isGreaterThanZero_throwsException() {
		// register user whose id is greater than 0e
		
		List<Account> accounts = new ArrayList<Account>();
		Account a = new Account();
		
		accounts.add(a);
		
		dummyUser = new User(23, "Bob", "Password", Role.Customer, accounts);
		uservice.register(dummyUser); // this will throw an exception because the
		// user that we're trying to register has an id > 0
	}
	

}
