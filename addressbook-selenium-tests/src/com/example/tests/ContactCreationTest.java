package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{
  @Test
  
  public void testEmptyContactCreation() throws Exception {
   openMainPage();
   gotoAddNewContact();
   ContactData contact = new ContactData();
// fillContactForm(contact);
   submitContactForm();
   
   openMainPage();
   }
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	 // openMainPage();
    gotoAddNewContact();
    ContactData contact = new ContactData();
	contact.firstname="lorem";
	contact.lastname = "ipsum";
	contact.address = "some street 66";
	contact.telefhome = "123132";
	contact.telefmobile = "789798";
	contact.companyname = "companyname";
	contact.email1 = "emailname@gmail.com";
	contact.email2 = "emailname2@gmail.com";
	contact.bday = "9";
	contact.bmonth = "July";
	contact.byear = "1979";
	contact.selectgroup = "group 2";
	contact.address2 = "address post";
	contact.phone2 = "city";
			
	
    fillContactForm(contact);
    submitContactForm();
    openMainPage();
  }
}
