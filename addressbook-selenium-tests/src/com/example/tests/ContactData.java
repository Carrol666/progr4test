package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String telefhome;
	public String telefmobile;
	public String companyname;
	public String email1;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String selectgroup;
	public String address2;
	public String phone2;

	public ContactData() {
	
	}
	
	public ContactData(String firstname, String lastname, String address, String telefhome, String telefmobile,
			String companyname, String email1, String email2, String bday, String bmonth, String byear,
			String selectgroup, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.telefhome = telefhome;
		this.telefmobile = telefmobile;
		this.companyname = companyname;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.selectgroup = selectgroup;
		this.address2 = address2;
		this.phone2 = phone2;
	}
}