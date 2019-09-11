/**
 * 
 */
package com.springboot.rest.crud.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author rmamidala
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -6420227864129505036L;

	public StudentNotFoundException(String exception) {
		super(exception);
	}

}
