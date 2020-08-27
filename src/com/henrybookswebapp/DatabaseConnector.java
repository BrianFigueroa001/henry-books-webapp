package com.henrybookswebapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector
{
	private final String URL;
	private final String USERNAME;
	private final String PASSWORD;

	public DatabaseConnector()
	{
		URL = "jdbc:mysql://localhost:3306/henrybooks";
		USERNAME = "root";
		PASSWORD = System.getenv("DB_PASSWORD");
	}

	public Connection getDatabaseConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return connection;
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
