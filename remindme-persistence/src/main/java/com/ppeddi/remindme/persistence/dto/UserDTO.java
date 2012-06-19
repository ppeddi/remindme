/**
 * 
 */
package com.ppeddi.remindme.persistence.dto;

/**
 * @author ppeddi
 * 
 */
public class UserDTO {
	private String userId;
	private String userName;
	private String firstName;
	private String lastName;
	private EncodedUserPasswordDTO encodedPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EncodedUserPasswordDTO getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(EncodedUserPasswordDTO encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

}
