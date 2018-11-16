package com.vstu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends NamedException {

	public EntityNotFoundException(String message) {
		super(message, EntityNotFoundException.class);
	}
}
