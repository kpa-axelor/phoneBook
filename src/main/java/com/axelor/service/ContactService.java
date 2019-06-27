package com.axelor.service;

import java.util.List;

public interface ContactService {
	
	public void insert(String name , String phoneNumber , String type);
	public List retrive();
	public void update(int contactId,String contactName,String type,int phoneId,String phoneNumber);
	public void delete(int contactId,int phoneId);
}
