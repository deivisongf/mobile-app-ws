package com.r4s.app.sw.exceptions;

public class UserServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1350295789346476842L;

	public UserServiceException(String message) {
		super(message);
	}
}
