package com.example.tests;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{
  @Test(dataProvider = "randomValidContactGenerator")
  
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
   app.getNavigationHelper().openMainPage();
   // save old state
   List<ContactData> oldList = app.getContactHelper().getContacts();
  // actions
   
   app.getContactHelper().gotoAddNewContact();
   app.getContactHelper().fillContactForm(contact);
   app.getContactHelper().submitContactForm();
   
   app.getNavigationHelper().openMainPage();
   
   // save new sate
   List<ContactData> newList = app.getContactHelper().getContacts();
  // compare states

   oldList.add(contact);
   Collections.sort(oldList);
   assertEquals(newList, oldList);
   }
  
 
}
