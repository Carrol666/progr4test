package com.example.tests;

	import org.testng.annotations.Test;

	public class ContactRemovalTests extends TestBase{

		@Test
		
	       public void deleteSomeContact() {
			app.getNavigationHelper().openMainPage();
		    app.getContactHelper().gotoEditContactPage(1);
		    app.getContactHelper().submitDeleteContact();
		    app.getNavigationHelper().openMainPage();
		}
	
}
