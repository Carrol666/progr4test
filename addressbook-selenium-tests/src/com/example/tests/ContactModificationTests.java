package com.example.tests;


	import org.testng.annotations.Test;

	public class ContactModificationTests extends TestBase{

		@Test
		
	       public void ModifySomeContact() {
			app.getNavigationHelper().openMainPage();
		    app.getContactHelper().gotoEditContactPage(1);
		    ContactData contact = new ContactData();
			contact.firstname = "new First Name";
			contact.lastname = "new Lasr Name";
			
		    app.getContactHelper().fillContactForm(contact);
		    app.getNavigationHelper().openMainPage();
		}
	
}
