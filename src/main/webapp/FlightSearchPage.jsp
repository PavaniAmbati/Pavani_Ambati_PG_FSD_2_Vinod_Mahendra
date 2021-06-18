<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
Statement statement1 = null;
ResultSet resultSet = null;
ResultSet resultSet1 = null;
%>

<%
try{ 
connection = DriverManager.getConnection(url, user, password);
statement=connection.createStatement();
statement1=connection.createStatement();
String sql ="SELECT * FROM source_city";
String sql1 ="SELECT * FROM destination_city";
resultSet = statement.executeQuery(sql);
resultSet1 = statement1.executeQuery(sql1);
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
<h1 style="font-family:Gabriola; color:darkblue;font-size: 50px;"> FlyAway</h1>
<h4 style="color:darkblue"> Airline Booking Portal</h4>

<form action="FlightsDisplay.jsp" method="post">
<!--  <table border=2 style="color:brown"> -->

<hr size = "2" color="brown" />
<tbody>

	<div></div>
	
	<tr>
		<td> <b>Leaving from:</b> </td>
		<td>	
			<select name = "Leaving from" required>
			 <option value=""> </option>
			<% while(resultSet.next()){ %>
				<option><%= resultSet.getString("city")%></option>
	<% 	} %>
			 				
			</select>
		</td>
	</tr>
	
	<tr>
		<td> <b>Going to:</b> </td>
		<td>
			<select name = "Going to" required>
			<option value=""> </option>
				<% while(resultSet1.next()){ %>
				<option><%= resultSet1.getString("city")%></option>
	<% 	} %>
			</select>
		</td>
	</tr>
	<br><br>
	<tr>
		<td> <b>Departure date:</b> </td>
		<td> <input type = "date" name = "departuredate" min="2021-06-17" required>  
		</td>
	</tr>

	<tr>
		<td> <b>Return date:</b> </td>
		<td> <input type = "date" name = "returndate" min="2021-06-17" required>  
		</td>
	</tr>
	<br><br>
	<tr>
		<td> <b>Number of people traveling</b> </td>
		<td> <input type="number" min="1" step="1" max="100" name="travelers" required/> </td>
	</tr>
	<br><br>
	<tr>
		<td>&nbsp;</td>
		<td><input type="submit" value="Search" name="btnsearch">
		&nbsp; <input type="submit" value="Clear" name="btnclear">
		</td>
	</tr>

</tbody>

</table>
</body>
</form>
</html>

