package com.GenericUtilies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtils {
	
	Connection con = null;
	public void connectToDB() throws SQLException
	{
		//Register database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DBUserName,IpathConstants.DBPassword);
	}
	
	public void executeAndGetData(String query, int ColIndex, String expData) throws SQLException
	{
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		
		boolean flag = false;
		while(result.next())
		{
			String actualData = result.getString(ColIndex);
			if(actualData.equalsIgnoreCase(expData))
					{
	                  flag = true;
	                  break;
					}
		}
		if(flag==true)
		{
			System.out.println("-------data is present-------");
		}
		else 
		{
			System.out.println("-------data is not present-------");
		}
	}
	
	public void disconnectDB() throws SQLException
	{
		con.close();
	}
}
