package com.revature.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

/*
 * Connection Pooling means that connections are REUSED rather than created
 * each time a connection is requested
 * 
 * In order to facilitate connection reuse, a memory cache of database connections
 * called a CONNECTION POOL, is mantained by a connection pooling module
 * as a layer on top of any standard JDBC driver product
 * 
 */

public class ConnectionPool {
	
	/*
	 * We will use this class to suply general database credentials and attain
	 * an object called GenericObjectPool
	 * 
	 * gPool is a special object that holds all the connection to our databases
	 * 
	 * 
	 */
	
	// if you were doing this in your own project, or in real application, use the applications.properties
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String JDBC_DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	static final String JDBC_USER = "postgres";
	static final String JDBC_PASS = "postgres";
	
	
	private static GenericObjectPool gPool = null;
	
	// Apache commons dbcp gives us the functionality to create a connection pool. but we have to do so 
	// by using ots specific class and functionality called GenericObjectPool
	
	public DataSource setUpPool() throws Exception {
		// We use the DataSource interface to create a connection object that participates in connection pooling
		
		Class.forName(JDBC_DRIVER);
		
		// create an instance of the generic object pool tha holds hour pool of connection objects 
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);
		
		// Create a connection factoruy object which will be used by the pool object to create the connections 
		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
		
		// Create a poolableCOnnectionFactory that will wrap around the connection
		
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
		
		return new PoolingDataSource(gPool);
		
	}
	
	public GenericObjectPool getCOnnectionPool() {
		return gPool;
	}
	
	// for our own benefit let's create a method to print the connection pool status
	public void printDbStatus() {
		System.out.println("Max: " + getCOnnectionPool().getMaxActive() + "; Active: " + getCOnnectionPool().getNumActive() + 
				"; Idle: " + getCOnnectionPool().getNumIdle());
		
		
	}

}
