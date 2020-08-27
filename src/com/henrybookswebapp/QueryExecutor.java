package com.henrybookswebapp;

import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryExecutor
{
	public void executeSelectQuery(final Connection connect,
								   final String TABLE_NAME,
								   final ArrayList<ArrayList<String>> RESULTS_LIST) throws SQLException
	{
		final String STATEMENT = "SELECT * FROM " + TABLE_NAME + ";";
		final PreparedStatement QUERY = connect.prepareStatement(STATEMENT);

		final ResultSet RESULTS = QUERY.executeQuery();

		int resultIndex = 0;
		while (RESULTS.next())
		{
			RESULTS_LIST.add(new ArrayList<>());

			for (int columnNum = 1; columnNum <= RESULTS.getMetaData().getColumnCount(); columnNum++)
			{
				RESULTS_LIST.get(resultIndex).add(RESULTS.getString(columnNum));
			}

			resultIndex++;
		}

		RESULTS.close();
		QUERY.close();
	}

	public String executeInsertQuery(final Connection DB_CONNECTION,
									 final String TABLE_NAME,
									 final String... COLUMN_ARGS)
	{
		String result;

		try
		{
			String insertStatement = "INSERT INTO " + TABLE_NAME + " VALUES(";

			for (int column = 1; column <= COLUMN_ARGS.length; column++)
			{
				if (column == COLUMN_ARGS.length)
				{
					insertStatement += "?);";
				}
				else
				{
					insertStatement += "?, ";
				}
			}

			PreparedStatement query = DB_CONNECTION.prepareStatement(insertStatement);

			for (int i = 0; i < COLUMN_ARGS.length; i++)
			{
				int column = i + 1;

				if (StringUtils.isStrictlyNumeric(COLUMN_ARGS[i]))
				{
					int columnValue = Integer.parseInt(COLUMN_ARGS[i]);
					query.setInt(column, columnValue);
				}
				else
				{
					String columnValue = COLUMN_ARGS[i];
					query.setString(column, columnValue);
				}
			}

			query.executeUpdate();

			result = "<br><br>Insertion successful!\n<br><br>";

			query.close();
			DB_CONNECTION.close();
		}
		catch (SQLException | NumberFormatException e)
		{
			result = "<br><br>Insertion failed\n<br>";
			e.printStackTrace();
		}


		return result;
	}

	public String executeDeleteQuery(final Connection DB_CONNECTION,
									 final String TABLE_NAME,
									 final String PRIMARY_KEY_NAME,
									 final int PRIMARY_KEY_SELECTED)
	{
		{
			String result;

			try
			{
				String deleteStatement = "DELETE FROM " + TABLE_NAME + " WHERE " + PRIMARY_KEY_NAME + " = ?;";
				PreparedStatement query = DB_CONNECTION.prepareStatement(deleteStatement);

				int parameterNum = 1;
				query.setInt(parameterNum, PRIMARY_KEY_SELECTED);

				query.executeUpdate();

				result = "<br><br>Delete successful!\n<br><br>";

				query.close();
				DB_CONNECTION.close();
			}
			catch (SQLException | NumberFormatException e)
			{
				result = "<br><br>Deletion failed!\n<br>";
				e.printStackTrace();
			}

			return result;
		}
	}

}
