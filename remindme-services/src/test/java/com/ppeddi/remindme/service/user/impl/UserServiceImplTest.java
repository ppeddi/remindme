/**
 * 
 */
package com.ppeddi.remindme.service.user.impl;

import javax.annotation.Resource;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppeddi.remindme.domain.User;
import com.ppeddi.remindme.service.password.EncodedUserPassword;
import com.ppeddi.remindme.service.password.PasswordManager;
import com.ppeddi.remindme.service.user.UserService;

/**
 * @author ppeddi
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:remindme-services.xml", "classpath:mock-remindme-password.xml" })
public class UserServiceImplTest {

	@Resource
	UserService userService;
	
	@Resource
	PasswordManager passManager;
	
	public void setup() {
		EasyMock.reset(passManager);
	}

	private User createUser(String userName) {
		User user = new User();
		user.setUserName(userName);
		user.setFirstName("FirstName");
		user.setLastName("LastName");
		user.setRawPassword("password");
		return user;
	}

	@Test
	public void testCreateUser() {
		User user = createUser("testCreateUser");
		EasyMock.expect(passManager.encode(user.getRawPassword())).andReturn(new EncodedUserPassword("", "".getBytes()));
		EasyMock.replay(passManager);
		
		userService.createUser(user);
		
		EasyMock.verify(passManager);
	}

	@Test
	public void testUpdateUser() {
		// TODO implement this
	}

	@Test
	public void deleteCreateUser() {
		// TODO implement this
	}

	@Test
	public void retrieveCreateUser() {
		// TODO implement this
	}
}
