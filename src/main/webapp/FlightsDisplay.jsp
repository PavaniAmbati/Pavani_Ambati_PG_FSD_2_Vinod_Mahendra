<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%
String driverClassName = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/pgfsd_flyaway?useSSL=false"; //change it
String user = "root";
String password = "Simplilearn$1";

try {
Class.forName(driverClassName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
String sourcecity=request.getParameter("Leaving from");
String destinationcity=request.getParameter("Going to");
String travelers=request.getParameter("travelers");
String departuredate=request.getParameter("departuredate");
%>

<%
try{ 
connection = DriverManager.getConnection(url, user, password);
statement=connection.createStatement();
PreparedStatement st=connection.prepareStatement("SELECT fr.route_id, fr.flightname, fr.sourcecity, fr.destinationcity, fr.price, fs.departuredate, fs.arrivaldate FROM pgfsd_flyaway.flight_route fr inner join pgfsd_flyaway.flight_schedule fs on fr.route_id=fs.route_id where fr.sourcecity = ? and fr.destinationcity = ? and fs.departuredate>= ?");
st.setString(1, sourcecity);
st.setString(2, destinationcity);
st.setString(3, departuredate);
resultSet=st.executeQuery();
} catch (Exception e) {
e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body style="background-color:mintcream;">
<form action="RegistrationPage.jsp" method="post">
<h1 style="font-family:Gabriola; color:darkblue;font-size: 50px;"> FlyAway</h1>
<h4 style="color:darkblue"> Airline Booking Portal</h4>
<hr size = "2" color="black" />
<h3>Flight Search Results</h3>

<table border="1">
		<tr>
			<td><b>Flight Name</b></td>
			<td><b>From</b></td>
			<td><b>To</b></td>
			<td><b>Price</b></td>
			<td><b>Departure Date</b></td>
			<td><b>Arrival Date</b></td>
			<td><b>No of travelers</b></td>
			<td><b>Total Price</b></td>
		</tr>
	<% 	while(resultSet.next()){%>
		<tr>
			<td><input type="text" name="flightname" value="<%=resultSet.getString("flightname")%>" readonly></td>
			<td><input type="text" name="sourcecity" value="<%=resultSet.getString("sourcecity")%>" readonly></td>
			<td><input type="text" name="destinationcity" value="<%=resultSet.getString("destinationcity")%>" readonly></td>
			<td><input type="text" name="price" value="<%=resultSet.getString("price")%>" readonly></td>
			<td><input type="text" name="departuredate" value="<%=resultSet.getString("departuredate")%>" readonly></td>
			<td><input type="text" name="arrivaldate" value="<%=resultSet.getString("arrivaldate")%>" readonly></td>
			<td><input type="text" name="travelers" value="<%=travelers%>"  readonly></td>
			<td><input type="submit" value="Select" name="select">
		</tr>
		<%}%>
		
</form>
</body>
</html>



	