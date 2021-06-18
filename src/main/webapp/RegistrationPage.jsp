<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
String flightname=request.getParameter("flightname");
String sourcecity=request.getParameter("sourcecity");
String destinationcity=request.getParameter("destinationcity");
String price= request.getParameter("price");
String travelers= request.getParameter("travelers");
String departuredate= request.getParameter("departuredate");
String arrivaldate= request.getParameter("arrivaldate");
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body style="background-color:mintcream;">
<h1 style="font-family:Gabriola; color:darkblue;font-size: 50px;"> FlyAway</h1>
<h4 style="color:darkblue"> Airline Booking Portal</h4>
<hr size = "2" color="black" />
<form action = "/PG_FSD_P2_Project/Registration" method = "POST">

<h3>Registration Page</h3>

<h4>Enter customer info</h4>
		<lable for="firstname">First Name</lable>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "text" name="firstname" required> 
	<br><br>
		<lable for="lastname">Last Name </lable>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type = "text" name="lastname" required> 
	<br><br>
		<lable for="phonenumber">Phone Number </lable>
		<input type="tel" id="phone" name="phone" required> 
	<br><br>
		<lable for="email">Email</lable>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="email" id="email" name="email" required>
	
<h4>Enter payment info</h4>
	<lable for="paymentmethod">Payment Method </lable><br><br>
	<input type="radio" id="visa" name="paymentmethod" value="visa" required>
	<label for="visa">Visa</label>
	<input type="radio" id="mastercard" name="paymentmethod" value="mastercard">
	<label for="mastercard">MasterCard</label>
	<input type="radio" id="discovery" name="paymentmethod" value="discovery">
	<label for="discovery">Discovery</label><br><br>
	<lable for="card">Card Number</lable>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="cardnumber" required>
	<br><br>
	<input type="submit" value="Submit" name="submit">&nbsp;&nbsp;
	<input type="reset" value="Clear" name="clear">
	<br><br>
	<input type = "hidden" name="flightname" value="<%=flightname%>"  style=" color:mintcream;" readonly> 
	<input type = "hidden" name="sourcecity" value="<%=sourcecity%>"  style=" color:mintcream;" readonly> 
	<input type = "hidden" name="destinationcity" value="<%=destinationcity%>"  style="color:mintcream;" readonly> 
	<input type = "hidden" name="price" value="<%=price%>"  style="color:mintcream;" readonly> 
	<input type = "hidden" name="travelers" value="<%=travelers%>"  style="color:mintcream;" readonly> 
	<input type = "hidden" name="departuredate" value="<%=departuredate%>"  style="color:mintcream;" readonly> 
	<input type = "hidden" name="arrivaldate" value="<%=arrivaldate%>"  style="color:mintcream;" readonly> 
</form>
</body>

</html>
