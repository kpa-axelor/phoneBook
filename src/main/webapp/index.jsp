<html>
<body>
	<form name="contact-form"
		action="<%=request.getContextPath()%>/ContactResource/insert"
		method="POST">
		Name: <input type="text" name="name" /> </br> 
		<select name= "type">
			<option value="PersonalNumber" name="PersonalNumber">PersonalNumber</option>
			<option value="HomeNumber" name = "HomeNumber">HomeNumber</option>
			<option value="OfficeNumber" name = "OfficeNumber">OfficeNumber</option>
		</select> 
		PhoneNumber <input	type="text" name="phoneNumber"> </br> 
		<input type="submit" value="insert" name="insert" />
	</form>
</body>
</html>