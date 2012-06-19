/**
 * 
 */
package com.ppeddi.remindme.service.password;

import sun.misc.BASE64Encoder;

/**
 * @author ppeddi
 * 
 */
public class EncodedUserPassword {
	String encodedPassword;
	byte[] salt;

	public EncodedUserPassword(String encodedPassword, byte[] salt) {
		super();
		this.encodedPassword = encodedPassword;
		this.salt = salt;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public byte[] getSalt() {
		return salt;
	}
	
	public String getSaltBase64() {
		return (new BASE64Encoder()).encode(salt);
	}

}
