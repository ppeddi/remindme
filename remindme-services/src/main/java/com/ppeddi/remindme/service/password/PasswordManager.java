/**
 * 
 */
package com.ppeddi.remindme.service.password;


/**
 * @author ppeddi
 *
 */
public interface PasswordManager {

	/**
	 * Encodes the raw password and returns the object that wraps both encoded password and salt
	 * 
	 * @param rawPassword
	 * @return
	 */
	EncodedUserPassword encode(String rawPassword);
	
	/**
	 * Verifies if the rawPassword after encoding matches with encoded password
	 * 
	 * @param rawPassword
	 * @param encodedPassword
	 * @return
	 */
	boolean verifyPassword(String rawPassword, EncodedUserPassword encodedPassword);
}
