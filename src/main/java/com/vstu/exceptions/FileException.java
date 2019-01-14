package com.vstu.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class FileException extends NamedException {

	public FileException(String message) {
		super(message,FileException.class);
		
	}	
	

}
