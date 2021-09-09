package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection; // This is JDBC
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;


// Singleton design pattern instantiates an object ONCE

/**
 * Singleton design pattern
 * 
 * -- private constructors
 * -- static field of an instance of the class to be returned
 * -- leverage a public static getInstance() (our getInstance )
 * @author ron
 *
 */


public class ConnectionUtil {
	
	private static Logger log = Logger.getLogger(ConnectionUtil.class);
	private static Connection conn = null;
	
	// we want to make the constructor private 
	private ConnectionUtil() {
		super();
	}
	
	// in a singleton design pattern you create a static "getInstance()
	public static Connection getConnection() {
		
		try {
			if (conn != null && !conn.isClosed() ) {
				return conn;
			}
		} catch (SQLException e) {
			
			// Implement an error log here
			
			return null;
		}
		
		Properties prop = new Properties(); // access the properties in the application.properties file
		
		String url = "";
		String username = "";
		String password = "";
		
		try {
			prop.load(new FileReader("/home/ron/Documents/Revature/revature-notes/JDBCdemo/src/main/resources/application.properties"));
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection successful!");
			
		} catch (IOException e) {
			// TODO add some logging
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO add some logging 
			return null;
		}

		return conn;
		
	}
}
