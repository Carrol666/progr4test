package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.example.utils.SortedListOf;


import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTest extends TestBase{
  @Test(dataProvider = "randomValidContactGenerator")
  
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
   app.navigateTo().mainPage();
   // save old state
   SortedListOf<ContactData> oldList = (SortedListOf<ContactData>) app.getContactHelper().getContacts();
  // actions
   
   app.getContactHelper().createContact(contact, CREATION);
    
 
   
   // save new sate
   SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
  // compare states
   assertThat(newList, equalTo(oldList.withAdded(contact)));
  
   }
  
 
}
