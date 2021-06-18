<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login form</title>
</head>
<body style="background-color:mintcream;">
<h1 style="font-family:Gabriola; color:darkblue;font-size: 50px;">FlyAway</h1>
<h2 style="font-family:Gabriola; color:darkblue;font-size: 30px;">Admin Login Form</h2>
<hr/>
<form action = "/PG_FSD_P2_Project/LoginValidation" method = "POST">
<p>User Name : <input type="text" name="username" required/></p>
<p>Password: <input type="password" name="password" required/></p>

<p>
	<input type = "submit" value="Login" name="Login"/> &nbsp;
	<input type="reset" value="Clear" name="btnclear"/>&nbsp;
	<input type="submit" value="Udpate Password" name="UpdatePassword" formnovalidate/>
</p>

<p>${message}</p>
<c:remove var="message" scope="session" />

</form>

</body>
</html>