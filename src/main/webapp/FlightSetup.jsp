<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.*" %>
    
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
Statement statement2 = null;
Statement statement3 = null;
Statement statement4 = null;
Statement statement5 = null;
Statement statement6 = null;

ResultSet resultSet2 = null;
ResultSet resultSet3 = null;
ResultSet resultSet4 = null;
ResultSet resultSet5 = null;
ResultSet resultSet6 = null;

%>

<%
try{ 
connection = DriverManager.getConnection(url, user, password);
statement2=connection.createStatement();
statement3=connection.createStatement();
statement4=connection.createStatement();
statement5=connection.createStatement();
statement6=connection.createStatement();

String sql2 ="SELECT flight_name FROM flight_list";
String sql3 ="SELECT flight_name FROM flight_list";
String sql4 ="SELECT city FROM source_city";
String sql5 ="SELECT city FROM destination_city";
String sql6 ="SELECT fr.route_id, fr.flightname, fr.sourcecity, fr.destinationcity, fr.price, fs.departuredate, fs.arrivaldate FROM flight_route fr inner join flight_schedule fs on fr.route_id=fs.route_id";

resultSet2 = statement2.executeQuery(sql2);
resultSet3 = statement3.executeQuery(sql3);
resultSet4 = statement4.executeQuery(sql4);
resultSet5 = statement5.executeQuery(sql5);
resultSet6 = statement6.executeQuery(sql6);

} catch (Exception e) {
e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminPage</title>
</head>
<form action="/PG_FSD_P2_Project/FlightSetup" method="POST"> 
<input class="submit" type="submit" value="Logout" name = "logout" formnovalidate/>
<body style="background-color:mintcream;">
<h1 style="font-family:Gabriola; color:darkblue;font-size: 50px;">FlyAway</h1>
<h2 style="font-family:Gabriola; color:darkblue;font-size: 30px;">AdminPage</h2>


<hr size = "2" color="black" />

<h2 style="color:black;font-size: 20px;">FlightRoute setup</h2>

	<tr>
		<td> <b>Flight Name</b> </td>
		<td>	
			<select name = "Flight Name" required>
			 <option value=""> </option>
			<% while(resultSet3.next()){ %>
				<option><%= resultSet3.getString("flight_name")%></option>
	<% 	} %>
			 				
			</select>
		</td>
	</tr>
	<br><br>
	<tr>
		<td> <b>Source city list</b> </td>
		<td>	
			<select name = "Source city" required>
			 <option value=""> </option>
			<% while(resultSet4.next()){ %>
				<option><%= resultSet4.getString("city")%></option>
	<% 	} %>
			 				
			</select>
		</td>
	</tr>
	<br><br>
	<tr>
		<td> <b>Destination city list</b> </td>
		<td>
			<select name = "Destination city" required>
			<option value=""> </option>
				<% while(resultSet5.next()){ %>
				<option><%= resultSet5.getString("city")%></option>
	<% 	} %>
			</select>
		</td>
	</tr>
	<br><br>
	<tr>
		<td> <b>Price</b> </td>
		<td> <input type="number" name="Price" min="0.01" step="0.01" max="2500" required/> </td>
	</tr>
	<br><br>
	
	<tr>
		<td> <b>Departure Date</b> </td>
		<td> <input type="date" name="departuredate" min="2021-06-17" required/> </td>
	</tr>
	
	<tr>
		<td> <b>Arrival Date</b> </td>
		<td> <input type="date" name="arrivaldate" min="2021-06-17" required/> </td>
	</tr>
	<br><br>
	<tr>
		<td>&nbsp;<input type="submit" value="Add new route" name="save">
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="reset" value="Clear" name="clear">
		</td>
	</tr>
	
<hr size = "2" color="black" />

	<tr>
		<td> <b>Flight Name</b> </td>
		<td>	
			<select name = "removeflight">
			 <option value=""> </option>
			<% while(resultSet2.next()){ %>
				<option><%= resultSet2.getString("flight_name")%></option>
	<% 	} %>
			 				
			</select>
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="submit" value="Remove route" name="removeroute" formnovalidate></td>
	</tr>
				
<hr size = "2" color="black" />
			<p>${message}</p>
<c:remove var="message" scope="session" />


<h3>List of all Flight Routes</h3>
	<table border="1">
		<tr>
			<td><b>Route ID</b></td>
			<td><b>Flight Name</b></td>
			<td><b>From</b></td>
			<td><b>To</b></td>
			<td><b>Price</b></td>
			<td><b>Departure Date</b></td>
			<td><b>Arrival Date</b></td>
		</tr>
		
	<% 	while(resultSet6.next()){%>
		<tr>
			<td><%=resultSet6.getString("route_id") %></td>
			<td><%=resultSet6.getString("flightname") %></td>
			<td><%=resultSet6.getString("sourcecity") %></td>
			<td><%=resultSet6.getString("destinationcity") %></td>
			<td><%=resultSet6.getString("price") %></td>
			<td><%=resultSet6.getString("departuredate") %></td>
			<td><%=resultSet6.getString("arrivaldate") %></td>
		</tr>
		<%}%>
	
	
	
	</table>
	
<style>
.submit
{
    float: right;
    border: none;
    background: #EDEDED;
    color: arial;
    font-size: 20px;
    padding: 5px 10px;
    top: 10px;
	right: 10px;
}
.submit:hover
{
    background: red;
    cursor: pointer;
}
</style>

</body>
</form>
</html>