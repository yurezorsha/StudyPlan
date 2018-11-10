package com.vstu.exceptions;

public class EntityNotFoundException extends NamedException {

	public EntityNotFoundException(String message) {
		super(message, EntityNotFoundException.class);
	}
}
