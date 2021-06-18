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
Statement statement2 = null;
Statement statement3 = null;
Statement statement4 = null;
Statement statement5 = null;
ResultSet resultSet = null;
ResultSet resultSet1 = null;
ResultSet resultSet2 = null;
ResultSet resultSet3 = null;
ResultSet resultSet4 = null;
ResultSet resultSet5 = null;
%>

<%
try{ 
connection = DriverManager.getConnection(url, user, password);
statement=connection.createStatement();
statement1=connection.createStatement();
statement2=connection.createStatement();
statement3=connection.createStatement();
statement4=connection.createStatement();
statement5=connection.createStatement();
String sql ="SELECT city FROM source_city";
String sql1 ="SELECT city FROM destination_city";
String sql2 ="SELECT flight_name FROM flight_list";
String sql3 ="SELECT flight_name FROM flight_list";
String sql4 ="SELECT city FROM source_city";
String sql5 ="SELECT city FROM destination_city";
resultSet = statement.executeQuery(sql);
resultSet1 = statement1.executeQuery(sql1);
resultSet2 = statement2.executeQuery(sql2);
resultSet3 = statement3.executeQuery(sql3);
resultSet4 = statement4.executeQuery(sql4);
resultSet5 = statement5.executeQuery(sql5);
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
<body style="background-color:mintcream;">
<form action="/PG_FSD_P2_Project/Admin" method="POST"> 
<input class="submit" type="submit" value="Logout" name = "logout"/>

<h1 style="font-family:Gabriola; color:darkblue;font-size: 50px;">FlyAway</h1>
<h2 style="font-family:Gabriola; color:darkblue;font-size: 30px;">AdminPage - Flight Setup</h2>



<hr size = "2" color="black" />
	<tr>
		<td> <b>Source city list</b> </td>
		<td>	
			<select name = "Source city">
			 <option value=""> </option>
			<% while(resultSet.next()){ %>
				<option><%= resultSet.getString("city")%></option>
	<% 	} %>
			 				
			</select>
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="submit" value="Remove city" name="delete source">
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
	<tr>
		<td> Add new source city </td>
		<td> <input type = "text" name="new source"> </td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="submit" value="Submit" name="add source">
		</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
	<br><br>
	
	<tr>
		<td> <b>Destination city list</b> </td>
		<td>
			<select name = "Destination city">
			<option value=""> </option>
				<% while(resultSet1.next()){ %>
				<option><%= resultSet1.getString("city")%></option>
	<% 	} %>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="submit" value="Remove city" name="delete destination">
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
	<tr>
		<td> Add new destination city </td>
		<td> <input type = "text" name="new destination"> </td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="submit" value="Submit" name="add destination">
		</td>
	</tr> 
	
	<br><br>
	
	<tr>
		<td> <b>Flight list</b> </td>
		<td>	
			<select name = "Flight Name">
			 <option value=""> </option>
			<% while(resultSet2.next()){ %>
				<option><%= resultSet2.getString("flight_name")%></option>
	<% 	} %>
			 				
			</select>
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="submit" value="Remove flight" name="delete flight">
		</td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
	<tr>
		<td> Add new flight </td>
		<td> <input type = "text" name="new flight"> </td>
	</tr>
	
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="submit" value="Submit" name="add flight">
		</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	
		<p>${message}</p>
<c:remove var="message" scope="session" />

<hr size = "2" color="black" />
<h2 style="color:black;font-size: 15px;">Click below to setup flight route and schedule</h2>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;<input type="submit" value="Flight Route and Schedule Setup" name="next">
		</td>
	</tr>

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