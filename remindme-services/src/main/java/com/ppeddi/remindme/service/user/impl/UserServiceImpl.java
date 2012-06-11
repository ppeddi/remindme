/**
 * 
 */
package com.ppeddi.remindme.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ppeddi.remindme.domain.User;
import com.ppeddi.remindme.service.user.UserService;

/**
 * @author ppeddi
 *
 */
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.service.user.UserService#createUser(com.ppeddi.remindme.domain.User)
	 */
	public String createUser(User user) {
		// TODO Auto-generated method stub
		return "userCreated";
	}

	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.service.user.UserService#retrieveUser(java.lang.String)
	 */
	public User retrieveUser(String userId) {
		logger.info("In retrieveUser...");
		// TODO Auto-generated method stub
		return new User();
	}

	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.service.user.UserService#retrieveUserByName(java.lang.String)
	 */
	public User retrieveUserByName(String userName) {
		logger.info("In retrieveUserByName...");
		// TODO Auto-generated method stub
		return new User();
	}

	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.service.user.UserService#updateUser(com.ppeddi.remindme.domain.User)
	 */
	public void updateUser(User user) {
		logger.info("In updateUser...");
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ppeddi.remindme.service.user.UserService#deleteUser(java.lang.String)
	 */
	public void deleteUser(String userId) {
		logger.info("In deleteUser...");
		// TODO Auto-generated method stub

	}

}
