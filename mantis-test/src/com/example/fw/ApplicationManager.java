package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	
	private static ApplicationManager singleton;
	
	public static String baseUrl;
	
	private WebDriver driver;
	private Properties properties;

	private HibernateHelper hibernateHelper;
	private AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	
   public static ApplicationManager getInstance(Properties properties) {
		 if (singleton == null) {
			 singleton = new ApplicationManager();
		 }
		return singleton;
		  
		}

	public void stop() {
		 driver.quit();
		   
	}
    
	
			
	public HibernateHelper getHibernateHelper() {
		 if (hibernateHelper == null) {
			 hibernateHelper = new HibernateHelper(this);
		 }
		 return hibernateHelper;
	}

	public WebDriver getDriver() {
		 String browser = properties.getProperty("browser");
		if (driver == null) {
			if ("firefox".equals(browser)) {
				 driver = new FirefoxDriver();
			 } else if ("ie".equals(browser)) {
				 driver = new InternetExplorerDriver();
			 } else {
				 throw new Error("Unsupported browser: " + browser);
			 }
			driver = new FirefoxDriver();
			    baseUrl = properties.getProperty("baseUrl");
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.get(baseUrl);
		 }
		 return driver;
	
	}

	   public String getProperty(String key) {
		   return properties.getProperty(key);
	   }

	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);
		 }
		 return accountHelper;
	}

	public MailHelper getMailHelper() {
		if (mailHelper == null) {
			mailHelper = new MailHelper(this);
		 }
		 return mailHelper;
	}

	public JamesHelper getJamesHelper() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);
		 }
		 return jamesHelper;
	}
	
	
}
