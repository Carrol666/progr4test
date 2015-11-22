package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.tests.GroupDataGeneration.generateRandomGroups;
import static com.example.tests.ContactDataGeneration.generateRandomContacts;

public  class TestBase {
	
	protected static ApplicationManager app;
    
	
		@BeforeTest
	public void setUp() throws Exception {
			String configFile = System.getProperty("configFile, application.properties");
			Properties properties = new Properties();
			properties.load(new FileReader(new File(configFile)));
			app = new ApplicationManager(properties);
	   	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	   
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsToDataProvider(generateRandomGroups(5)).iterator();
	}
	
	public static List<Object[]> wrapGroupsToDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group: groups) {
			list.add(new Object[]{group});
		}
		return list;
	}
	

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wrapContactsToDataProvider(generateRandomContacts(5)).iterator();

	}

	public static List<Object[]> wrapContactsToDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact: contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}	
	}
	
}
