package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase {
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitContactForm() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.telefhome);
		type(By.name("mobile"), contact.telefmobile);
		type(By.name("work"), contact.companyname);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
		
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"), contact.byear);
	   // selectByText(By.name("new_group"), contact.selectgroup);
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phone2);
	   	}

	
	public void gotoAddNewContact() {
		click(By.linkText("add new"));
	}

	public void gotoEditContactPage(int index) {
		editContactByIndex(index);
				
	}
	
	private void editContactByIndex(int index) {
		click(By.xpath(".//*[@id='maintable']//tr["+(index+1)+"]/td[7]/a"));
		
	}

	public void submitDeleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
    }
	
	public void submitUpdateContact() {
		click(By.xpath("(//input[@name='update'])[1]"));
    }

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> lastNames = driver.findElements(By.xpath("//tr[@name='entry']//td[2]"));
		List<WebElement> firstNames = driver.findElements(By.xpath("//tr[@name='entry']//td[3]"));
		for (int i = 0; i < firstNames.size(); i++) {
 			ContactData contact = new ContactData();
 			contact.lastname = lastNames.get(i).getText();
 			contact.firstname = firstNames.get(i).getText();
 			
 		    contacts.add(contact);
 		}
		return contacts;
	}
	
}
