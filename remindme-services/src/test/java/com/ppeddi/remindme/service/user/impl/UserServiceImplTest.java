/**
 * 
 */
package com.ppeddi.remindme.service.user.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppeddi.remindme.domain.User;
import com.ppeddi.remindme.service.user.UserService;

/**
 * @author ppeddi
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:remindme-services.xml" })
public class UserServiceImplTest {

	@Resource
	UserService userService;

	private User createUser(String userName) {
		User user = new User();
		user.setUserName(userName);
		user.setFirstName("FirstName");
		user.setLastName("LastName");
		return user;
	}

	@Test
	public void testCreateUser() {
		User user = createUser("testCreateUser");
		userService.createUser(user);
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
