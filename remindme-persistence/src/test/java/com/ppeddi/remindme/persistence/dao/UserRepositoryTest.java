package com.ppeddi.remindme.persistence.dao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sun.misc.BASE64Encoder;

import com.ppeddi.remindme.persistence.dto.EncodedUserPasswordDTO;
import com.ppeddi.remindme.persistence.dto.UserDTO;
import com.ppeddi.remindme.persistence.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mongo-repository.xml" })
public class UserRepositoryTest {
	@Resource
	UserRepository userRepo;

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
		 userRepo.deleteAll();
	}

	@Test
	public void testCreateUser() {
		UserDTO expectedDTO = createUserDTO("testCreateUser");
		UserDTO actualDTO = userRepo.save(expectedDTO);
		List<UserDTO> users = userRepo.findAll();
		System.out.println("Users1:" + users);
		Assert.assertEquals(1, users.size());
		Assert.assertEquals(expectedDTO, actualDTO);
	}

	@Test
	public void testCreateDuplicateUser() {
		userRepo.save(createUserDTO("testCreateDuplicateUser"));
		System.out.println("Users:" + userRepo.findAll());
		userRepo.save(createUserDTO("testCreateDuplicateUser"));
		System.out.println("Users:" + userRepo.findAll());
	}

	private UserDTO createUserDTO(String string) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(string);
		userDTO.setUserId(UUID.randomUUID().toString());
		userDTO.setFirstName("FirstName");
		userDTO.setLastName("LastName");

//		EncodedUserPasswordDTO encodedPass = new EncodedUserPasswordDTO("password", new BASE64Encoder().encode("salt"
//				.getBytes()));
//		userDTO.setEncodedPassword(encodedPass);
		return userDTO;
	}
}
