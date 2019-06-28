<html>
<body>
	<form action="<%=request.getContextPath()%>/ContactResource/update"
		method="POST">
		contactId : <input type ="text" name="contactId" value =<%= request.getParameter("contactId") %> /></br>
		contactName: <input type="text" name="contactName"  value = <%= request.getParameter("contactName") %> /> </br> 
		
		<select name= "type">
			<option value = <%= request.getParameter("phoneType") %>   name="PersonalNumber">PersonalNumber</option>
			<option  value = <%= request.getParameter("phoneType") %>  name = "HomeNumber">HomeNumber</option>
			<option  value = <%= request.getParameter("phoneType") %>  name = "OfficeNumber">OfficeNumber</option>
		</select> </br>
		phoneId : <input type="text" name="phoneId"  value = <%= request.getParameter("phoneId") %> ></br>
		PhoneNumber <input	type="text" name="phoneNumber"  value = <%= request.getParameter("phoneNumber") %> /> </br> 
		<input type="submit" value="Save" name="Save" />
	</form>
</body>
</html>