/**
 * 
 */
package com.ppeddi.remindme.rest.impl;

import com.ppeddi.remindme.domain.User;
import com.ppeddi.remindme.rest.UserRestService;
import com.ppeddi.remindme.service.user.UserService;

/**
 * @author ppeddi
 *
 */
public class UserRestServiceImpl implements UserRestService {
	
	UserService userService;
	
	
	public UserRestServiceImpl(UserService userService) {
		this.userService = userService;
	}

	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.rest.UserRestService#createUser(com.ppeddi.remindme.domain.User)
	 */
	public String createUser(User user) {
		return userService.createUser(user);		
	}

	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.rest.UserRestService#updateUser(com.ppeddi.remindme.domain.User)
	 */
	public void updateUser(User user) {
		userService.updateUser(user);
	}

	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.rest.UserRestService#retrieveUser(java.lang.String)
	 */
	public User retrieveUser(String userId) {
		return userService.retrieveUser(userId);
	}

	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.rest.UserRestService#retrieveUserByUserName(java.lang.String)
	 */
	public User retrieveUserByUserName(String userName) {
		return userService.retrieveUserByName(userName);
	}

}
