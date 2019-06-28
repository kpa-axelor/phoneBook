<html>
<head>
<script>
function add_field()
{
  var total_text=document.getElementsByClassName("input_text");
  total_text=total_text.length+1;
  document.getElementById("field_div").innerHTML=document.getElementById("field_div").innerHTML+
  "<p id='input_text"+total_text+"_wrapper'><input type='text' name='phoneNumber' class='input_text' id='input_text"+total_text+"' placeholder='Enter Text'><input type='button' value='Remove' onclick=remove_field('input_text"+total_text+"');></p>";
}
function remove_field(id)
{
  document.getElementById(id+"_wrapper").innerHTML="";
}
</script>
</head>
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
	
		<select name= "type">
			<option value="PersonalNumber" name="PersonalNumber">PersonalNumber</option>
			<option value="HomeNumber" name = "HomeNumber">HomeNumber</option>
			<option value="OfficeNumber" name = "OfficeNumber">OfficeNumber</option>
		</select> 
		PhoneNumberTwo <input	type="text" name="phoneNumber"> </br> 
		<div id="field_div">
		<input type="button" value="Add" onclick="add_field();">
		</div>
		<input type="submit" value="insert" name="insert" />
		
	</form>
	<a href="/phonebook/search.jsp">search contect by name</a> 
</body>
</html>