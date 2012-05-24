/**
 * 
 */
package com.ppeddi.remindme.service.user;

import com.ppeddi.remindme.domain.User;

/**
 * @author ppeddi
 * 
 */
public interface UserService {

	String createUser(User user);

	User retrieveUser(String userId);

	User retrieveUserByName(String userName);

	void updateUser(User user);

	void deleteUser(String userId);

}
