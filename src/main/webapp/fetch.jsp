<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.axelor.db.Contact"%>
<%@page import="com.axelor.db.Phone"%>
<html>

<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body> 

<table style="width: 60%">
	
		<%  List<Contact> contactList = (List<Contact>)request.getAttribute("contactList"); %>
<!-- 		<tr> -->
<%-- 			<td><% out.print("contactId"); %></td> --%>
<%-- 			<td><% out.print("contactName"); %></td> --%>
<%-- 			<td><% out.print("phoneId"); %></td> --%>
<%-- 			<td><% out.print("PhoneNumber"); %></td> --%>
<%-- 			<td><% out.print("phoneType"); %></td> --%>
<!-- 		</tr> -->
	
		<% for (Contact contact : contactList) 
		{  %>
			
			
			<% List<Phone> phoneList = new ArrayList<Phone>(); 
				phoneList = contact.getPhoneList();
				out.print(phoneList.size());%>
				
			<% for (Phone phone : phoneList) { %>
				<form action="../update.jsp" method="POST">	
			<tr>
			<td>  <input type="text" value = "<% out.print(contact.getId()); %>" name="contactId" /> </td>
			<td>  <input type="text" value = "<% out.print(contact.getName()); %>" name="contactName" /> </td>
			<td> <input type="text" value = "<% out.print(phone.getId()); %>" name = "phoneId"/> </td>
			<td> <input type="text" value = "<% out.print(phone.getPhoneNumber()); %>"  name = "phoneNumber"/> </td>
			<td> <input type="text" value = "<% out.print(phone.getType()); %>" name = "phoneType"/> </td>	
			<td><input type="submit" value = "Edit" name ="edit" >
			<td><a name="contactId" href = "<%=request.getContextPath()%>/ContactResource/phonedelete/<%=phone.getId()%> ">phoneDelete</a></td>
			<td><a name="contactId" href = "<%=request.getContextPath()%>/ContactResource/contactdelete/<%=contact.getId()%> ">Contactdelete</a></td>
					
				</form>
			
		<% } %>
			<tr>	
			</tr>
			<%} %>
</table>
</body>
</html>