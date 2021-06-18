<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Update Form</title>
</head>
<body style="background-color:mintcream;">
<h1 style="font-family:Gabriola; color:darkblue;font-size: 50px;">FlyAway</h1>
<h2 style="font-family:Gabriola; color:darkblue;font-size: 30px;">AdminPage - Password Update Form</h2>
<hr/>
<form action = "/PG_FSD_P2_Project/PasswordUpdate" method = "POST" >
<p><b>Enter User Name : </b><input type="text" name="username" required/></p>
<p><b>Enter Old Password:</b> <input type="password" name="oldpassword" required/></p>
<p><b>Enter New Password: </b><input type="password" name="newpassword" required/></p>
<%String errorMsg=(String)request.getAttribute("message"); %>


	<input type = "submit" value="Update Password" name = "Update"/> &nbsp;
	<input type="reset" value="Clear"/>&nbsp;
	<input type = "submit" value="Back to login page" name = "Back" formnovalidate/> &nbsp;
	
	<p>${message}</p>
<c:remove var="message" scope="session" />

</p>
</form>

</body>
</html>