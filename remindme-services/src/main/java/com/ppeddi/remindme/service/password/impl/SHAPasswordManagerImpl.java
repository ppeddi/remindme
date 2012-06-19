/**
 * 
 */
package com.ppeddi.remindme.service.password.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.ppeddi.remindme.service.exceptions.PasswordEncodingException;
import com.ppeddi.remindme.service.password.EncodedUserPassword;
import com.ppeddi.remindme.service.password.PasswordManager;

/**
 * This implementation uses SHA encoder from Spring. Algorithm is configurable in spring context
 * 
 * @author ppeddi
 * 
 */
public class SHAPasswordManagerImpl implements PasswordManager {
	ShaPasswordEncoder encoder;

	public SHAPasswordManagerImpl(ShaPasswordEncoder encoder) {
		super();
		this.encoder = encoder;
	}

	public EncodedUserPassword encode(String rawPassword) {

		if (rawPassword == null) {
			throw new PasswordEncodingException("Null password is not allowed.");
		}
		SecureRandom random;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			throw new PasswordEncodingException("Failed to get random salt.", e);
		}
		// generate random 16 bit salt. use secure random
		byte[] salt = new byte[16];
		random.nextBytes(salt);

		String encodedPassword = encoder.encodePassword(rawPassword, salt);
		// always return encoded password and salt together so that salt will be generated everytime password is encoded.
		return new EncodedUserPassword(encodedPassword, salt);
	}

	public boolean verifyPassword(String rawPassword, EncodedUserPassword encodedPassword) {
		if (rawPassword == null) {
			throw new PasswordEncodingException("Null password is not valid.");
		}
		return encoder.isPasswordValid(encodedPassword.getEncodedPassword(), rawPassword, encodedPassword.getSalt());
	}

}
