package com.example.tests;


import java.io.FileReader;

import java.util.Properties;

import java.util.logging.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;


public  class TestBase {
	
	protected Logger log = Logger.getLogger("TEST");
	protected static ApplicationManager app;
    
	
		@BeforeClass
		@Parameters({"configFile"})
	public void setUp(@Optional String configFIle) throws Exception {
			if (configFIle == null) {
				configFIle = System.getProperty("configFile");
			}
			
			if (configFIle == null) {
				configFIle = System.getenv("configFile");
			}
			
		
			Properties properties = new Properties();
			properties.load(new FileReader(configFIle));
			log.info("setUp start");
			app = ApplicationManager.getInstance(properties);
			//app.setProperties(properties);
			log.info("setUp end");
	   	  }

	@AfterTest
	public void tearDown() throws Exception {
		log.info("setUp start");
		ApplicationManager.getInstance(null).stop();
		log.info("setUp end");
	   }


	

	
}
