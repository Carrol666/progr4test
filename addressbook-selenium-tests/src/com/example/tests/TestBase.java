package com.example.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected ApplicationManager app;
    
	
		@BeforeTest
	public void setUp() throws Exception {
			app = new ApplicationManager();
	   	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	   
	  }

	

	

}
