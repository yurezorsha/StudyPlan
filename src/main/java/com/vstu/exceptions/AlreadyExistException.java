package com.vstu.exceptions;

public class AlreadyExistException extends NamedException {

	public AlreadyExistException(String message) {
		super(message, AlreadyExistException.class);

	}

}
