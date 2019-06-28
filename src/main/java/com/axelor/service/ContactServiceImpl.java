package com.axelor.service;

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
	public void insert(String name, String[] phoneNumber, String[] type) {
		entityManager = entityManagerProvider.get();
		Contact contact = new Contact(name);
		entityManager.persist(contact);
		System.out.println(phoneNumber.length);
		Phone[] phone = new Phone[phoneNumber.length];
		for (int i = 0; i < phoneNumber.length; i++) {
			phone[i] = new Phone();
			System.out.println("i = " + i);
			phone[i].setPhoneNumber(phoneNumber[i]);
			phone[i].setType(type[i]);
			entityManager.persist(phone[i]);
			phone[i].setContact(contact);
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Contact> readAllContacts() {
		entityManager = entityManagerProvider.get();
		Query query = entityManager.createQuery("from Contact");
		List<Contact> contactList = (List<Contact>) query.getResultList();
		return contactList;

	}

	@Transactional
	public void update(int contactId, String contactName, String type, int phoneId, String phoneNumber) {
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
	public void deletePhone(int phoneId) {
		entityManager = entityManagerProvider.get();
		Phone phone = entityManager.find(Phone.class, phoneId);
		entityManager.remove(phone);
	}

	@Transactional
	public void deleteContact(int contactId) {
		entityManager = entityManagerProvider.get();
		Contact contact = entityManager.find(Contact.class, contactId);
		entityManager.remove(contact);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Contact> searchContact(String name) {
		entityManager = entityManagerProvider.get();
		Query query = entityManager.createQuery("Select c from Contact c where c.name LIKE '%" + name + "%'");
		List<Contact> contactList = (List<Contact>) query.getResultList();
		System.out.println(contactList.size());
		return contactList;
	}

}
