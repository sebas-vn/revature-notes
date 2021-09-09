package com.revature.exceptions;

public class RegisterUserFailedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 729971464218959125L;

	public RegisterUserFailedException(String message) {
		super(message);
		
	}
}
