package com.advjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionUtils 
{
	//This method create the Connection return the connection
	public static Connection createConnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return connection;
	}

}