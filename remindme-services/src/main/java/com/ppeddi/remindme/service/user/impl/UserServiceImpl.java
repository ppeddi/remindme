/**
 * 
 */
package com.ppeddi.remindme.service.user.impl;

import java.util.UUID;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Encoder;

import com.ppeddi.remindme.domain.User;
import com.ppeddi.remindme.persistence.dto.EncodedUserPasswordDTO;
import com.ppeddi.remindme.persistence.dto.UserDTO;
import com.ppeddi.remindme.service.password.EncodedUserPassword;
import com.ppeddi.remindme.service.password.PasswordManager;
import com.ppeddi.remindme.service.user.UserService;

/**
 * @author ppeddi
 * 
 */
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	PasswordManager passManager;
	Mapper mapper;

	public UserServiceImpl(PasswordManager passwordManager, Mapper mapper) {
		this.passManager = passwordManager;
		this.mapper = mapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ppeddi.remindme.service.user.UserService#createUser(com.ppeddi.remindme.domain.User)
	 */
	public String createUser(User user) {
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		userDTO.setUserId(UUID.randomUUID().toString());
		EncodedUserPassword encodedPass = passManager.encode(user.getRawPassword());
		userDTO.setEncodedPassword(new EncodedUserPasswordDTO(encodedPass.getEncodedPassword(), new BASE64Encoder().encode(encodedPass.getSalt())));
		
		//persist the dto
		
		return userDTO.getUserId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ppeddi.remindme.service.user.UserService#retrieveUser(java.lang.String)
	 */
	public User retrieveUser(String userId) {
		logger.info("In retrieveUser...");
		// TODO Auto-generated method stub
		return new User();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ppeddi.remindme.service.user.UserService#retrieveUserByName(java.lang.String)
	 */
	public User retrieveUserByName(String userName) {
		logger.info("In retrieveUserByName...");
		// TODO Auto-generated method stub
		return new User();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ppeddi.remindme.service.user.UserService#updateUser(com.ppeddi.remindme.domain.User)
	 */
	public void updateUser(User user) {
		logger.info("In updateUser...");
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ppeddi.remindme.service.user.UserService#deleteUser(java.lang.String)
	 */
	public void deleteUser(String userId) {
		logger.info("In deleteUser...");
		// TODO Auto-generated method stub

	}

}
