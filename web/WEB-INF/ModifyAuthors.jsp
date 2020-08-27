<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifying Authors Table</title>
</head>
<body>

<form action="maintenance">
	Click here to go back to previous page!
	<input type="submit" value="Maintenance">
</form>
<br>

<p>
	Authors stored in database<br><br>
	Columns: authorNum -- authorLast -- authorFirst<br><br>
</p>
<table>
	<%
		ArrayList<ArrayList<String>> AUTHOR_RESULTS = (ArrayList<ArrayList<String>>) request.getAttribute("author");
		for (int rowIndex = 0; rowIndex < AUTHOR_RESULTS.size(); rowIndex++)
		{
	%>
	<tr>
		<%
			for (int columnIndex = 0; columnIndex < AUTHOR_RESULTS.get(rowIndex).size(); columnIndex++)
			{
		%>
		<td>
			<%=AUTHOR_RESULTS.get(rowIndex).get(columnIndex)%>
		</td>
		<%
			}
		%>
	</tr>
	<%
		}
	%>
</table>
<br><br>

<br>
<form action="insertauthor">
	Insert new row -
	Author Number: <input type="text" name="authorNum">
	Author Last: <input type = "text" name="authorLast">
	Author First: <input type ="text" name="authorFirst">
	<input type="submit" value = "Submit">
</form>
<br>
<form action="deleteauthor">
	Delete row -
	Author Number: <input type="text" name="authorNum">
	<input type="submit" value = "Submit">
</form>
<br>

</body>
</html>