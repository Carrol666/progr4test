package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGeneration.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGeneration.loadContactsFromXmlFile;


public class ContactCreationTest extends TestBase{
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapContactsToDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}
	
	
	
	
  @Test(dataProvider = "contactsFromFile")
  
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
