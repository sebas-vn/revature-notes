package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/*
 * JDBC API main Classes and Interfaces:
 * https://www.tutorialspoint.com/what-are-the-main-classes-and-interfaces-of-jdbc
 * 
 * (1) DriverManager class
 * 	- This class manages the JDBC drivers.
 * 	- Some static methods, such as getConnection() that we use to connect to a DB
 * 	- Used to obtain a Connection
 * 
 * (2) Connection Interface
 * 	- Represents a Connection to our DB
 * 	- Has methods to obtain Statements
 * 	- This interface provides methods such as close(), commit(), rollback(), 
 * 		createStatement(), prepareCall(), prepareStatement(), setAutoCommit() setSavepoint() etc.
 * 
 * (3) Statement Interface
 * 	- Represents a static SQL statement that will be performed against the DB
 * 	- There are sub-interfaces for specific use-cases
 * 		- PreparedStatement Interface 
 * 			- CallableStatement Interface
 * 	- Have methods to obtain ResultSets
 * 
 * (4) ResultSet Interface
 * 	- Represents data obtained from the DB
 * 	- Follows an "Iterator" structure
 * 		- Is pointing to individual rows
 * 		- Invoke the .next() method to step forward
 * 		- Starts at the position BEFORE the first row
 * 	- Has methods to obtain data from individual columns for that row
 * 		- getInt()
 * 		- getString()
 * 
 * (5) CallableStatement Interface
 * 	- Using an object of this interface you can execute stored procedures. 
 * 	- Methods include prepareCall()
 * 	- A stored procedure is a prepared SQL code that you can save, so the code can be reused over and over again.
 */

public class UserDao implements IUserDao {
	
	private static Logger log = Logger.getLogger(UserDao.class);

	@Override
	public int insert(User u) { // Think about the User u passed as a parameter as being generated from the input that
								// a user gives through the console

		try {

			// Capture the single instance of the JDBC Connection (this is called a session)
			Connection conn = ConnectionUtil.getConnection();

			/* We start with a SQL String -- "RETURNING" allows us to return the PK of the
			 * user inserted/created */
			String sql = "INSERT INTO sebasvn.users (username, pwd, user_role) VALUES (?, ?, ?) RETURNING sebasvn.users.id";

			/*
			 * Defend against SQL injection with a Prepared Statement! If you don't use a
			 * Prepared Statement, a malicious actor could try to insert a statement like
			 * "DROP TABLE USERS". SQL Injection is typically the #1 Cyber Threat listed by
			 * OWASP. https://owasp.org/www-project-top-ten/
			 */
			PreparedStatement stmt = conn.prepareStatement(sql);

			/**
			 * Here we are replacing the ?'s of the sql String with the instance variables
			 * of the User u object passed as a parameter to be persisted. 
			 */
			stmt.setString(1, u.getUsername()); // The "1" represents the 1st ? in the SQL insertion String
			stmt.setString(2, u.getPassword());

			/** Transposing an the ENUM from Java -> SQL, is tough because we have to
			 *  accommodate for a separate custom ENUM type.
			 */
			stmt.setObject(3, u.getRole(), Types.OTHER);

			/**
			 * When we run stmt.executeQuery(), it returns a ResultSet Object. The ResultSet
			 * Interface has all of the methods we need to iterate over the returned data. */
			ResultSet rs;

			// first we check to see if the returned result set is NOT null...
			if ((rs = stmt.executeQuery()) != null) {
				
				// move the cursor of the ResultSet forward 1 with next()
				rs.next();
				
				// all we need is the FIRST column's data (which is the PK of the inserted User)
				int id = rs.getInt(1); // the "1" parameter represents the 1st column of data that we want
				
				log.info("Successfully insert user with id" + id);
				// if everything goes well, we return that fetched PK
				return id;
			}

		} catch (SQLException e) {
			log.error("Unable to insert User");
			e.printStackTrace();
		}

		/**
		 * Since this method returns an int (as specified in the IUserDao Interface),
		 * return -1 if things go wrong inserting a User in the DB, because Users can't
		 * have a negative ID
		 */
		return -1;
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// TODO: add more IUserDao method implementations

}