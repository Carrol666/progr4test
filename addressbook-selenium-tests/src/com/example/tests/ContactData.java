package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String telefhome;
	private String telefmobile;
	private String companyname;
	private String email1;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String selectgroup;
	private String address2;
	private String phone2;

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

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ContactData other) {
		int res = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		 if (res!=0){
			 return res;
		 }
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}

	public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
		return this;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public ContactData withAddress(String address) {
			this.address = address;
			return this;
	}

	public ContactData withTelefhome(String telefhome) {
		this.telefhome = telefhome;
		return this;
	}
	
	public ContactData withTelefmobile(String telefmobile) {
		this.telefmobile = telefmobile;
		return this;
	}

	public ContactData withCompanyname(String companyname) {
		this.companyname = companyname;
		return this;
	}
	
	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getTelefhome() {
		return telefhome;
	}

	public String getTelefmobile() {
		return telefmobile;
	}

	public String getCompanyname() {
		return companyname;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getSelectgroup() {
		return selectgroup;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}
	
}