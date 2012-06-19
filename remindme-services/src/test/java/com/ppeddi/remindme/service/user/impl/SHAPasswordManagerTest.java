/**
 * 
 */
package com.ppeddi.remindme.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ppeddi.remindme.service.exceptions.PasswordEncodingException;
import com.ppeddi.remindme.service.password.EncodedUserPassword;
import com.ppeddi.remindme.service.password.PasswordManager;

/**
 * @author ppeddi
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:remindme-password-management.xml" })
public class SHAPasswordManagerTest {
	Logger logger = LoggerFactory.getLogger(SHAPasswordManagerTest.class);
	@Resource
	PasswordManager passwordManager;

	@Test
	public void testEncode() {
		String rawPassword = "safhfslfwDFHYEsdfd1233d!" + System.currentTimeMillis();
		EncodedUserPassword encodedUserPassword = passwordManager.encode(rawPassword);
		Assert.assertTrue(passwordManager.verifyPassword(rawPassword, encodedUserPassword));
	}

	@Test(expected = PasswordEncodingException.class)
	public void testEncodeWithNullPassword() {
		passwordManager.encode(null);
	}
	
	@Test(expected = PasswordEncodingException.class)
	public void testVerifyWithNullPassword() {
		passwordManager.verifyPassword(null, new EncodedUserPassword("", "".getBytes()));
	}

	@Test
	@Ignore
	public void testEncodePerf() {
		int count = 100000;
		long start = System.currentTimeMillis();
		List<EncodedUserPassword> encodedUserPasswords = new ArrayList<EncodedUserPassword>();
		List<String> rawPasswords = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			String rawPassword = "safhfslfwDFHYEsdfd1233d!" + System.nanoTime();
			encodedUserPasswords.add(passwordManager.encode(rawPassword));
			rawPasswords.add(rawPassword);
		}
		System.out.println("Encode rate:" + (count * 1000) / (System.currentTimeMillis() - start) + "/sec");
		start = System.currentTimeMillis();
		int index = 0;
		for (EncodedUserPassword encodedUserPassword : encodedUserPasswords) {
			Assert.assertTrue(passwordManager.verifyPassword(rawPasswords.get(index++), encodedUserPassword));
		}
		System.out.println("Verify rate:" + (count * 1000) / (System.currentTimeMillis() - start) + "/sec");
	}

}
