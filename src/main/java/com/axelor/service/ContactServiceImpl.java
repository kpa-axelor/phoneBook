package com.axelor.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.db.Contact;
import com.axelor.db.Phone;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class ContactServiceImpl implements ContactService {

	@Inject
	Provider<EntityManager> entityManagerProvider;

	EntityManager entityManager;

	@Transactional
	public void insert(String name, String phoneNumber, String type) {
		entityManager = entityManagerProvider.get();
		Contact contact = new Contact(name);
		Phone phone = new Phone(phoneNumber, type);
		entityManager.persist(contact);
		entityManager.persist(phone);
		phone.setContact(contact);
	}

	public List<Contact> retrive() {
		entityManager = entityManagerProvider.get();
		Query query = entityManager.createQuery("from Contact");
		List<Contact> contactList = query.getResultList();
		return contactList;

	}
	@Transactional
	public void update(int contactId,String contactName,String type,int phoneId,String phoneNumber)	{
		entityManager = entityManagerProvider.get();
		System.out.println(contactId);
		System.out.println(contactName);
		System.out.println(phoneId);
		System.out.println(phoneNumber);
		Contact contact = entityManager.find(Contact.class, contactId);
		contact.setName(contactName); 
		System.out.println(contact.getName());
		Phone phone = entityManager.find(Phone.class, phoneId);
		phone.setPhoneNumber(phoneNumber);
		System.out.println(phone.getPhoneNumber());
		entityManager.persist(contact);
		entityManager.persist(phone);
		
	}
	@Transactional
	public void delete(int contactId,int phoneId)
	{
		entityManager = entityManagerProvider.get();
		Contact contact = entityManager.find(Contact.class, contactId);
		Phone phone = entityManager.find(Phone.class, phoneId);
		List<Phone> phoneList = new ArrayList<Phone>();
		phoneList = contact.getPhoneList();
		System.out.println(phoneList.size());
		if(phoneList.size() > 1)
		{
			
			entityManager.remove(phone);
		}
		else
		{
			
			entityManager.remove(contact);
			entityManager.remove(phone);
		}
	}
}
