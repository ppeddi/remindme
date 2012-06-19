/**
 * 
 */
package com.ppeddi.remindme.persistence.dto;

/**
 * @author ppeddi
 * 
 */
public class EncodedUserPasswordDTO {
	String encodedPassword;
	String saltBase64;

	public EncodedUserPasswordDTO(String encodedPassword, String saltBase64) {
		super();
		this.encodedPassword = encodedPassword;
		this.saltBase64 = saltBase64;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public String getSalt() {
		return saltBase64;
	}

}
