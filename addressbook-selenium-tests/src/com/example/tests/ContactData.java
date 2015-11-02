package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
	
}