<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>

<!--  
Host: 127.0.0.1
Port: 3306 
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<form action="view">
	Click here to view the contents of the Henry Books Database.
	<input type="submit" value="View Contents">
</form><br>

<form action="maintenance">
	Click here to make changes to the database.
	<input type="submit" value="Modify Database">
</form>

</body>
</html>