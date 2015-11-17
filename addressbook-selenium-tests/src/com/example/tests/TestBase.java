package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public  class TestBase {
	
	protected static ApplicationManager app;
    
	
		@BeforeTest
	public void setUp() throws Exception {
			app = new ApplicationManager();
	   	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	   
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
	List<Object[]> list = new ArrayList<Object[]>();	
		for (int i = 0; i < 5; i++) {
		GroupData group = new GroupData()
		 .withName(generateRandomString())
		 .withHeader(generateRandomString())
		 .withFooter(generateRandomString());
		
	    list.add(new Object[]{group});
	}
	return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}	
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
	List<Object[]> list = new ArrayList<Object[]>();	
		for (int i = 0; i < 5; i++) {
		ContactData contact = new ContactData()
		.withFirstname(generateRandomString())
		.withLastname(generateRandomString())
		.withAddress(generateRandomString())
		.withTelefhome(generateRandomString())
		.withTelefmobile(generateRandomString())
		.withCompanyname(generateRandomString())
		.withEmail1(generateRandomString() + "@gmail.com")
		.withEmail2(generateRandomString() + "@gmail.com")
		//contact.bday = "";
		//contact.bmonth = "";
		//contact.byear = "";
		//contact.selectgroup = generateRandomString();
		.withAddress2(generateRandomString())
		.withPhone2(generateRandomString());
	    list.add(new Object[]{contact});
	}
	return list.iterator();
	}

}
