/**
 * 
 */
package com.ppeddi.remindme.service.exceptions;

/**
 * @author ppeddi
 * 
 */
public class PasswordEncodingException extends UserServiceException {

	private static final long serialVersionUID = 1L;

	public PasswordEncodingException() {
		super();
	}

	public PasswordEncodingException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordEncodingException(String message) {
		super(message);
	}

	public PasswordEncodingException(Throwable cause) {
		super(cause);
	}

}
