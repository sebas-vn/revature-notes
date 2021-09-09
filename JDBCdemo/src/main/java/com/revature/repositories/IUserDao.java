package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

/**
 * DAO is a data access object
 * 
 * it is used to separates our persistance logic from our business logic and outline all crud funcionality on an object
 * @author ron
 *
 */
public interface IUserDao {
	int insert(User u); // we aim to return the primary key of the user inserted into the db
	User findByUserName(String username);
	List<User> findAll();
	boolean update(User u);
	boolean delete(int id);
}
