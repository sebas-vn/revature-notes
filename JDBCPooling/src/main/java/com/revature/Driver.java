package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.revature.util.ConnectionPool;

public class Driver {

	
	public static void main(String[] args) throws SQLException {
		ResultSet rs = null;
		Connection connObj = null;
		PreparedStatement pstmtObj = null;
		ConnectionPool jdbcObj = new ConnectionPool();
		
		
		// surround everything in try/catch block
		try {
			DataSource dataSource = jdbcObj.setUpPool();
			jdbcObj.printDbStatus();
			
			// get the connection (from the pool)
			System.out.println("============= Making a new connection Object for a DB operation ==============");
			connObj = dataSource.getConnection();
			
			// print the dbStatus()
			jdbcObj.printDbStatus();
			
			// use the fetched connection to execute a query (like select * from heroes)
			pstmtObj = connObj.prepareStatement("SELECT * FROM heroes");
			
			rs = pstmtObj.executeQuery();
			
			while(rs.next()) {
				System.out.println("Hero name is " + rs.getString("hero_name"));
			}
			
			
			
			jdbcObj.printDbStatus();
		} catch (Exception e) {
			
		} finally {
			
			System.out.println("===== Realeasing connection objects to pool ======");
			connObj.close(); // close the specific connection so it can be sent back to the pool
		}
		
	}
	
	
	
	
	
	
	// release the db connection object back to the pool
}
