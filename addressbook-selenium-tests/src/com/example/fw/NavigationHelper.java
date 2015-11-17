package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public void mainPage() {
		if (! onMainPage()){		
		 click(By.linkText("home"));
		}
		
	}
	
	public void groupsPage() {
		if (! onGourpPage()){
		 click(By.linkText("groups"));
		}
	}
	
	
	private boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size() > 0);
	}

	
	private boolean onGourpPage() {
		String currentUrl = driver.getCurrentUrl();
		driver.findElements(By.name("new"));
		if (driver.getCurrentUrl().contains("/group.php")
				&& driver.findElements(By.name("new")).size() > 0) {
			return true;
		}else{
			return false;
		}
		
	}

	

	

}
