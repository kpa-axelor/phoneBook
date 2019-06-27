package com.axelor.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.plugins.providers.html.View;

import com.axelor.db.Contact;
import com.axelor.db.Phone;
import com.axelor.service.ContactService;
import com.google.inject.Inject;

@Path("ContactResource")
public class ContactResource {

//	@Path("/name")
//	public void callName() {
//		System.out.print("kavan patel here");
//
//	}

//	@GET
//	@Path("test")
//	public void test() {
//		System.out.println("Test success!!");
//	}
	@Inject
	ContactService contactService;

	@POST
	@Path("/insert")
	public void insert(@Context HttpServletResponse response,
            @Context HttpServletRequest request,@FormParam("name") String name, @FormParam("phoneNumber") String phoneNumber,
			@FormParam("type") String type) throws ServletException, IOException {
		contactService.insert(name, phoneNumber, type);
		System.out.print(name);
		System.out.println(phoneNumber);
		System.out.println(type);
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = contactService.retrive();
		for (Contact contact : contactList) {
			System.out.println("id :" + contact.getId());
			System.out.println("name :" + contact.getName());
			List<Phone> phoneList = new ArrayList<Phone>();
			phoneList = contact.getPhoneList();
			for (Phone phone : phoneList) {
				System.out.println("phoneID :" + phone.getId());
				System.out.println("phoneType :" + phone.getType());
				System.out.println("phoneNumber :" + phone.getPhoneNumber());
			}
		}
		request.setAttribute("contactList", contactList);
		request.getRequestDispatcher("/fetch.jsp").forward(request, response);
//		return new View("/fetch.jsp",contactList ,"contactList");
	}
	
	@POST
	@Path("/update")
	public void update(@Context HttpServletResponse response,
            @Context HttpServletRequest request,@FormParam("contactId") String contactId ,@FormParam("contactName") String contactName,@FormParam("type") String type,@FormParam("phoneId") String phoneId,
						@FormParam("phoneNumber") String phoneNumber) throws ServletException, IOException
	{
		
			
		int contactId1 = Integer.parseInt(contactId);;
		int phoneId1 = Integer.parseInt(phoneId);
		if(null != request.getParameter("Save"))
		{
		contactService.update(contactId1,contactName,type,phoneId1,phoneNumber);
		}
		else
		{
			contactService.delete(contactId1,phoneId1);

		}
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = contactService.retrive();
		request.setAttribute("contactList", contactList);
		request.getRequestDispatcher("/fetch.jsp").forward(request, response);
	}
	
//	@POST
//	@Path("/delete")
//	public void delete(@FormParam("contactId") String contactId,@FormParam("phoneId") String phoneId)
//	{
//		int contactId1 = Integer.parseInt(contactId);;
//		int phoneId1 = Integer.parseInt(phoneId);
//	
//	}
	

}
