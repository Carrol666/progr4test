package com.example.tests;

import static org.testng.Assert.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;

public class SignupTest extends TestBase {
	
	User user = new User()
			.setLogin("testuser1")
			.setPassword("123456")
			.setEmail("testuser1@localhost.localdomain");
	
	private JamesHelper james;
	private AccountHelper accHelper;

	 @BeforeClass
	 public void createMailUser() {
		 james = app.getJamesHelper();
		 accHelper = app.getAccountHelper();
		 if (! james.doesUserExist(user.login)) {
			 james.createUser(user.login, user.password);
		 }
	 }
	 
	 
	@Test
	public void newUserShouldSingup()  {
		
		accHelper.signup(user);
		accHelper.login(user);
		assertThat(accHelper.loggedUser(), equalTo(user.login));
		
	}
	
	@Test
	public void existingUserShouldNotSingup()  {
		try {
		     accHelper.signup(user);
		} catch (Exception ex) {
		     assertThat(ex.getMessage(), containsString("That username is already being used"));
		     return;
		}		
		fail("Exception expected");
	
	}
	
	 @AfterClass
	 public void deleteMailUser() {
		 if (james.doesUserExist(user.login)) {
			 james.deleteUser(user.login);
		 }
	 }
	   
}
