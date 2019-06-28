package com.axelor.service;

import java.util.List;

import com.axelor.db.Contact;

public interface ContactService {

	public void insert(String name, String[] phoneNumber, String[] type);

	public List<Contact> readAllContacts();

	public void update(int contactId, String contactName, String type, int phoneId, String phoneNumber);

	public void deletePhone(int phoneId);

	public void deleteContact(int contactId);

	public List<Contact> searchContact(String name);
}
