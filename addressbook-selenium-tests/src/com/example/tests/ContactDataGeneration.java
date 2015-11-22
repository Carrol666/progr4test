package com.example.tests;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;


public class ContactDataGeneration extends TestBase {

	public static void main(String[] args) throws IOException {
		if (args.length < 4) {
			System.out.println("Please sepcify parametrs <amount of the test data> <file> <format>");
			return;
		}
        
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = new String(args[2]);
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually: "+ file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
	    } else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file)  throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		  for (ContactData contact : contacts) {
			  writer.write(contact.getFirstname()+ "," + contact.getLastname() + "," + contact.getAddress() + "," + contact.getTelefhome() + "!" + "\n");
		}
		writer.close();
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null){
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			  .withFirstname(part[0])
			  .withLastname(part[1])
			  .withAddress(part[2])
			  .withTelefhome(part[3]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
		}
	
	
	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();	
		for (int i = 0; i < amount; i++) {
		ContactData contact = new ContactData()
		.withFirstname(generateRandomString())
		.withLastname(generateRandomString())
		.withAddress(generateRandomString())
		.withTelefhome(generateRandomString())
		.withTelefmobile(generateRandomString())
		.withCompanyname(generateRandomString())
		.withEmail1(generateRandomString() + "@gmail.com")
		.withEmail2(generateRandomString() + "@gmail.com")
		//contact.bday = "";
		//contact.bmonth = "";
		//contact.byear = "";
		//contact.selectgroup = generateRandomString();
		.withAddress2(generateRandomString())
		.withPhone2(generateRandomString());
	    list.add(contact);
	}
	return list;

	}		
    
	
}

