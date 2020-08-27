package com.henrybookswebapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/modifyauthors")
public class ModifyAuthors extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DatabaseConnector connector = new DatabaseConnector();
		QueryExecutor executor = new QueryExecutor();
		final String AUTHOR_TABLE = "author";
		final ArrayList<ArrayList<String>> AUTHOR_RESULTS_LIST = new ArrayList<>();

		Connection connection = connector.getDatabaseConnection();

		if (connection != null)
		{
			try
			{
				executor.executeSelectQuery(connection, AUTHOR_TABLE, AUTHOR_RESULTS_LIST);

				connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		request.setAttribute(AUTHOR_TABLE, AUTHOR_RESULTS_LIST);
		request.getRequestDispatcher("WEB-INF/ModifyAuthors.jsp").forward(request, response);
	}
}
