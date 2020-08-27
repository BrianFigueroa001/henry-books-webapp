package com.henrybookswebapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/deleteauthor")
public class DeleteAuthor extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		final DatabaseConnector CONNECTOR = new DatabaseConnector();
		final QueryExecutor EXECUTOR = new QueryExecutor();
		final String CONNECTION_FAILED = "Failed to make a connection to the database.";
		String result;

		final Connection CONNECTION = CONNECTOR.getDatabaseConnection();

		if (CONNECTION != null)
		{
			final String AUTHOR_TABLE = "author";
			final String PRIMARY_KEY_NAME = "authorNum";
			final int PRIMARY_KEY_ROW_DELETE = Integer.parseInt(request.getParameter("authorNum"));

			result = EXECUTOR.executeDeleteQuery(CONNECTION, AUTHOR_TABLE, PRIMARY_KEY_NAME, PRIMARY_KEY_ROW_DELETE);
		}
		else
		{
			result = CONNECTION_FAILED;
		}

		request.setAttribute("result", result);
		request.getRequestDispatcher("WEB-INF/DeleteAuthor.jsp").forward(request, response);
	}
}
