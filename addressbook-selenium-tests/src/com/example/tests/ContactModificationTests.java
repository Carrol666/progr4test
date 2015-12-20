package com.example.tests;


	
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;
import java.util.Random;

import org.testng.annotations.Test;

	public class ContactModificationTests extends TestBase{

		@Test(dataProvider = "randomValidContactGenerator")
		
	       public void ModifySomeContact(ContactData contact) {
			// save old state
			SortedListOf<ContactData> oldList = app.getModel().getContacts();
			  
			   Random rnd = new Random();
			   int index = rnd.nextInt(oldList.size()-1); 
			  // actions
		    app.getContactHelper().modifyContact(index, contact);
		   	    
		 // save new sate
		    SortedListOf<ContactData> newList = app.getModel().getContacts();
		   // compare states
		    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
		    if (wantToCheck()) {
		        if("yes".equals(app.getProperty("check.db"))) {
		            assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));    	 	
		        }  
		        if("yes".equals(app.getProperty("check.ui"))) { 
		             assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));  
		     	}
		    }	 
	}
	
}
