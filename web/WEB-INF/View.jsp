<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!--
Host: 127.0.0.1
Port: 3306
-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Contents</title>
</head>
<body>

<form action="homepage">
    Click here to go back to home page!
    <input type="submit" value="Home Page">
</form>
<br>

<p>
    Authors stored in database<br>
    Columns: authorNum -- authorLast -- authorFirst<br>
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

<p>
    Books stored in database<br>
    Columns: bookCode -- title -- publisherCode -- type -- paperback<br>
</p>
<table>
    <%
        ArrayList<ArrayList<String>> BOOK_RESULTS = (ArrayList<ArrayList<String>>) request.getAttribute("book");
        for (int rowIndex = 0; rowIndex < BOOK_RESULTS.size(); rowIndex++)
        {
    %>
    <tr>
        <%
            for (int columnIndex = 0; columnIndex < BOOK_RESULTS.get(rowIndex).size(); columnIndex++)
            {
        %>
        <td>
            <%=BOOK_RESULTS.get(rowIndex).get(columnIndex)%>
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

<p>
    Branch stored in database<br>
    Columns: branchNum -- branchName -- branchLocation<br>
</p>
<table>
    <%
        ArrayList<ArrayList<String>> BRANCH_RESULTS = (ArrayList<ArrayList<String>>) request.getAttribute("branch");
        for (int rowIndex = 0; rowIndex < BRANCH_RESULTS.size(); rowIndex++)
        {
    %>
    <tr>
        <%
            for (int columnIndex = 0; columnIndex < BRANCH_RESULTS.get(rowIndex).size(); columnIndex++)
            {
        %>
        <td>
            <%=BRANCH_RESULTS.get(rowIndex).get(columnIndex)%>
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

<p>
    Copies stored in database<br>
    Columns: bookCode -- branchNum -- copyNum -- quality -- price <br>
</p>
<table>
    <%
        ArrayList<ArrayList<String>> COPY_RESULTS = (ArrayList<ArrayList<String>>) request.getAttribute("copy");
        for (int rowIndex = 0; rowIndex < COPY_RESULTS.size(); rowIndex++)
        {
    %>
    <tr>
        <%
            for (int columnIndex = 0; columnIndex < COPY_RESULTS.get(rowIndex).size(); columnIndex++)
            {
        %>
        <td>
            <%=COPY_RESULTS.get(rowIndex).get(columnIndex)%>
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

<p>
    Inventory stored in database<br>
    Columns: bookCode -- BranchName -- OnHand<br>
</p>
<table>
    <%
        ArrayList<ArrayList<String>> INVENTORY_RESULTS = (ArrayList<ArrayList<String>>) request.getAttribute("inventory");
        for (int rowIndex = 0; rowIndex < INVENTORY_RESULTS.size(); rowIndex++)
        {
    %>
    <tr>
        <%
            for (int columnIndex = 0; columnIndex < INVENTORY_RESULTS.get(rowIndex).size(); columnIndex++)
            {
        %>
        <td>
            <%=INVENTORY_RESULTS.get(rowIndex).get(columnIndex)%>
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

<p>
    Publisher stored in database<br>
    Columns: publisherCode -- publisherName -- city<br>
</p>
<table>
    <%
        ArrayList<ArrayList<String>> PUBLISHER_RESULTS = (ArrayList<ArrayList<String>>) request.getAttribute("publisher");
        for (int rowIndex = 0; rowIndex < PUBLISHER_RESULTS.size(); rowIndex++)
        {
    %>
    <tr>
        <%
            for (int columnIndex = 0; columnIndex < PUBLISHER_RESULTS.get(rowIndex).size(); columnIndex++)
            {
        %>
        <td>
            <%=PUBLISHER_RESULTS.get(rowIndex).get(columnIndex)%>
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

<p>
    Wrote stored in database<br>
    Columns: bookCode -- BranchName -- OnHand<br>
</p>
<table>
    <%
        ArrayList<ArrayList<String>> WROTE_RESULTS = (ArrayList<ArrayList<String>>) request.getAttribute("wrote");
        for (int rowIndex = 0; rowIndex < WROTE_RESULTS.size(); rowIndex++)
        {
    %>
    <tr>
        <%
            for (int columnIndex = 0; columnIndex < WROTE_RESULTS.get(rowIndex).size(); columnIndex++)
            {
        %>
        <td>
            <%=WROTE_RESULTS.get(rowIndex).get(columnIndex)%>
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

</body>
</html>