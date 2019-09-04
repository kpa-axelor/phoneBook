package com.axelor.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import com.axelor.db.Contact;
import com.axelor.service.ContactService;
import com.google.inject.Inject;

@Path("ContactResource")
public class ContactResource {
	@Inject
	ContactService contactService;

	@POST
	@Path("/insert")
	public void insert(@Context HttpServletResponse response, @Context HttpServletRequest request,
			@FormParam("name") String name, @FormParam("phoneNumber") String[] phoneNumber,
			@FormParam("type") String[] type) throws ServletException, IOException {
		contactService.insert(name, phoneNumber, type);
		response.sendRedirect(request.getContextPath() + "/ContactResource/showAll");
	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/update")
	public void update(@Context HttpServletResponse response, @Context HttpServletRequest request,
			@FormParam("contactId") String contactId, @FormParam("contactName") String contactName,
			@FormParam("type") String type, @FormParam("phoneId") String phoneId,
			@FormParam("phoneNumber") String phoneNumber) throws ServletException, IOException {

		
		int contactId1 = Integer.parseInt(contactId);
		int phoneId1 = Integer.parseInt(phoneId);
		contactService.update(contactId1, contactName, type, phoneId1, phoneNumber);
		response.sendRedirect(request.getContextPath() + "/ContactResource/showAll");
	}

	@Path("/phonedelete/{phoneId}")
	public void deletephone(@PathParam("phoneId") int phoneId, @Context HttpServletResponse response,
			@Context HttpServletRequest request) throws ServletException, IOException {
		System.out.println(phoneId);
		contactService.deletePhone(phoneId);
		response.sendRedirect(request.getContextPath() + "/ContactResource/showAll");
	}

	@Path("/contactdelete/{contactId}")
	public void contactdelete(@PathParam("contactId") int contactId, @Context HttpServletResponse response,
			@Context HttpServletRequest request) throws ServletException, IOException {
		System.out.println(contactId);
		contactService.deleteContact(contactId);
		response.sendRedirect(request.getContextPath() + "/ContactResource/showAll");
	}

	@Path("/showAll")
	public void showAll(@Context HttpServletResponse response, @Context HttpServletRequest request)
			throws ServletException, IOException {
		System.out.println("show all");
		List<Contact> contactList = new ArrayList<Contact>();
		contactList = contactService.readAllContacts();
		request.setAttribute("contactList", contactList);
		request.getRequestDispatcher("/fetch.jsp").forward(request, response);
	}

	@Path("/search")
	public void search(@Context HttpServletResponse response, @Context HttpServletRequest request)
			throws ServletException, IOException {

		String name = request.getParameter("searchname");
		System.out.println(name);
		List<Contact> contactList1 = new ArrayList<Contact>();
		contactList1 = contactService.searchContact(name);
		request.setAttribute("contactList", contactList1);
		request.getRequestDispatcher("/fetch.jsp").forward(request, response);
	}

}
