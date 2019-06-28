package com.axelor.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contact {
	@Id
	@GeneratedValue
	int id;
	String name;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contact" ,cascade  = CascadeType.ALL)
	List<Phone> phoneList = new ArrayList<Phone>();

	public Contact(String name) {
		this.name = name;
	}

	public Contact() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}

}
