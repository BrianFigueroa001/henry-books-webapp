package com.henrybookswebapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/insertauthor")
public class InsertAuthor extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final DatabaseConnector CONNECTOR = new DatabaseConnector();
		final QueryExecutor EXECUTOR = new QueryExecutor();
		final String CONNECTION_FAILED = "Failed to make a conenction to the database.";
		String result;

		Connection connection = CONNECTOR.getDatabaseConnection();

		if (connection != null)
		{
			final String AUTHOR_TABLE = "author";
			final String AUTHOR_NUM = request.getParameter("authorNum");
			final String AUTHOR_LAST = request.getParameter("authorLast");
			final String AUTHOR_FIRST = request.getParameter("authorFirst");

			result = EXECUTOR.executeInsertQuery(connection, AUTHOR_TABLE, AUTHOR_NUM, AUTHOR_LAST, AUTHOR_FIRST);
		}
		else
		{
			result = CONNECTION_FAILED;
		}

		request.setAttribute("result", result);
		request.getRequestDispatcher("WEB-INF/InsertAuthor.jsp").forward(request, response);
	}
}
