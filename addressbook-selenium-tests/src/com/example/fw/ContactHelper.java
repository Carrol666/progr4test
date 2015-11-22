package com.example.fw;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;
		
	public SortedListOf<ContactData> getContacts() {
		if(cachedContacts == null){
		    rebuildCache();
		  }
		  return cachedContacts;
	}

	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		List<WebElement> lastNames = driver.findElements(By.xpath("//tr[@name='entry']//td[2]"));
		List<WebElement> firstNames = driver.findElements(By.xpath("//tr[@name='entry']//td[3]"));
		for (int i = 0; i < firstNames.size(); i++) {
 			String lastname = lastNames.get(i).getText();
 			String firstname = firstNames.get(i).getText();
 			cachedContacts.add(new ContactData().withLastname(lastname).withFirstname(firstname));
 		}
	}

	public ContactHelper createContact(ContactData contact, boolean CREATION) {
		   gotoAddNewContact();
		   fillContactForm(contact, CREATION);
		   submitContactForm();
		   rebuildCache();
		   return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		gotoEditContactPage(index);
	    fillContactForm(contact, MODIFICATION);
	    submitUpdateContact();
	    rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		 gotoEditContactPage(index);
	     submitDeleteContact();
	     rebuildCache();
	     return this;
	}
	
	//**********************************************************

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getTelefhome());
		type(By.name("mobile"), contact.getTelefmobile());
		type(By.name("work"), contact.getCompanyname());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
		
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());
	    if (formType == CREATION) {
	   // selectByText(By.name("new_group"), contact.selectgroup);
	    }else{
	    	if(driver.findElements(By.name("new_group")).size() != 0) {
	      		throw new Error("Gourp selector exist in contact modification form");
	    	}
	    }
	    
	    type(By.name("address2"), contact.getAddress2());
	    
	    type(By.name("phone2"), contact.getPhone2());
	    return this;
	   	}

	
	public ContactHelper gotoAddNewContact() {
		manager.navigateTo().mainPage();
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper gotoEditContactPage(int index) {
		manager.navigateTo().mainPage();
		editContactByIndex(index);
		return this;
				
	}
	
	public ContactHelper submitContactForm() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}
	private ContactHelper editContactByIndex(int index) {
		manager.navigateTo().mainPage();
		click(By.xpath(".//*[@id='maintable']//tr["+(index+2)+"]/td[7]/a"));
		return this;
		
	}

	public ContactHelper submitDeleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		manager.navigateTo().mainPage();
		cachedContacts = null;
		return this;
    }
	
	public ContactHelper submitUpdateContact() {
		click(By.xpath("(//input[@name='update'])[1]"));
		manager.navigateTo().mainPage();
		cachedContacts = null;
		return this;
    }

	

	


	
}
