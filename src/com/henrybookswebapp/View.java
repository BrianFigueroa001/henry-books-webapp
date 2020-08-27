package com.henrybookswebapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/view")
public class View extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DatabaseConnector connector = new DatabaseConnector();
		QueryExecutor executor = new QueryExecutor();
		final String AUTHOR_TABLE = "author";
		final String BOOK_TABLE = "book";
		final String BRANCH_TABLE = "branch";
		final String COPY_TABLE = "copy";
		final String INVENTORY_TABLE = "inventory";
		final String PUBLISHER_TABLE = "publisher";
		final String WROTE_TABLE = "wrote";
		final ArrayList<ArrayList<String>> AUTHOR_RESULTS_LIST = new ArrayList<>();
		final ArrayList<ArrayList<String>> BOOK_RESULTS_LIST = new ArrayList<>();
		final ArrayList<ArrayList<String>> BRANCH_RESULTS_LIST = new ArrayList<>();
		final ArrayList<ArrayList<String>> COPY_RESULTS_LIST = new ArrayList<>();
		final ArrayList<ArrayList<String>> INVENTORY_RESULTS_LIST = new ArrayList<>();
		final ArrayList<ArrayList<String>> PUBLISHER_RESULTS_LIST = new ArrayList<>();
		final ArrayList<ArrayList<String>> WROTE_RESULTS_LIST = new ArrayList<>();


		Connection connection = connector.getDatabaseConnection();

		if (connection != null)
		{
			try
			{
				executor.executeSelectQuery(connection, AUTHOR_TABLE, AUTHOR_RESULTS_LIST);
				executor.executeSelectQuery(connection, BOOK_TABLE, BOOK_RESULTS_LIST);
				executor.executeSelectQuery(connection, BRANCH_TABLE, BRANCH_RESULTS_LIST);
				executor.executeSelectQuery(connection, COPY_TABLE, COPY_RESULTS_LIST);
				executor.executeSelectQuery(connection, INVENTORY_TABLE, INVENTORY_RESULTS_LIST);
				executor.executeSelectQuery(connection, PUBLISHER_TABLE, PUBLISHER_RESULTS_LIST);
				executor.executeSelectQuery(connection, WROTE_TABLE, WROTE_RESULTS_LIST);

				connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		request.setAttribute(AUTHOR_TABLE, AUTHOR_RESULTS_LIST);
		request.setAttribute(BOOK_TABLE, BOOK_RESULTS_LIST);
		request.setAttribute(BRANCH_TABLE, BRANCH_RESULTS_LIST);
		request.setAttribute(COPY_TABLE, COPY_RESULTS_LIST);
		request.setAttribute(INVENTORY_TABLE, INVENTORY_RESULTS_LIST);
		request.setAttribute(PUBLISHER_TABLE, PUBLISHER_RESULTS_LIST);
		request.setAttribute(WROTE_TABLE, WROTE_RESULTS_LIST);

		request.getRequestDispatcher("WEB-INF/View.jsp").forward(request, response);
	}
}
