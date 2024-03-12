package com.advjava.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao 
{
	

	public int createTable()
	{
		Connection connection = null;
		Statement statement = null;
		int result = 0;
		try
		{
			//create the connection object
			connection = DataBaseConnectionUtils.createConnection();
			//create the statement 
			statement = connection.createStatement();
			String query = "create table Employee(empId varchar2(20) primary key,empName varchar2(30),empSalary number)";
			//passing the query into executeupdate
			result = statement.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;	
	}
	public int saveEmployee(Employee e)
	{
		int result = 0;
		try(Connection connection = DataBaseConnectionUtils.createConnection())
		{
			//create the PS object with params
			PreparedStatement preparedStatement = connection.prepareStatement("insert into Employee values(?,?,?)");
			//set the data to params
			preparedStatement.setString(1, e.getEmpId());
			preparedStatement.setString(2, e.getEmpName());
			preparedStatement.setDouble(3, e.getEmpSalary());
			//execute the query
			result = preparedStatement.executeUpdate();
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return result;
		
	}
	public Employee findByEmpId(String empId)
	{
		Employee emp = null;
		try(Connection connection=DataBaseConnectionUtils.createConnection())
		{
			//create the PS object
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Employee where empId=?");
			//Set the data to params
			preparedStatement.setString(1, empId);
			//execute the query
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				//read the data from resultset and setting the data into Employee 
				emp = new Employee();
				emp.setEmpId(resultSet.getString(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setEmpSalary(resultSet.getDouble(3));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			return emp;	
	}
	public List<Employee> findAll()
	{
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp = null;
		try(Connection connection = DataBaseConnectionUtils.createConnection())
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Employee");
			while(resultSet.next())
			{
				//read the data from resultset and setting into Employee
				emp = new Employee();
				emp.setEmpId(resultSet.getString(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setEmpSalary(resultSet.getDouble(3));
				//adding employee into List
				employees.add(emp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return employees;
	}
	public int updateEmployee(double empSalary,double incValue)
	{	int result = 0;
		try(Connection connection = DataBaseConnectionUtils.createConnection())
		{	//create the PS object
			PreparedStatement preparedStatement = connection.prepareStatement("update Employee set empSalary=empSalary+? where empSalary>?");
			//set the data to params 
			preparedStatement.setDouble(1, incValue);
			preparedStatement.setDouble(2, empSalary);
			//execute the query 
			result =  preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		return result;
	}
	public int deleteByEmpId(String empId)
	{
		int result = 0;
		try(Connection connection = DataBaseConnectionUtils.createConnection())
		{
			//create the PS object
			PreparedStatement preparedStatement = connection.prepareStatement("delete from Employee  where empId=?");
			//set the data to params 
			preparedStatement.setString(1,empId );
		
			//execute the query 
			result =  preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteByEmpSalary(double empSalary)
	{
		int result = 0;
		try(Connection connection = DataBaseConnectionUtils.createConnection())
		{
			//create the PS object
			PreparedStatement preparedStatement = connection.prepareStatement
			("delete from Employee where empSalary>=?");
			//set the data to params 
			preparedStatement.setDouble(1,empSalary);
			//execute the query 
			result =  preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public int dropTable()
	{	int result=0;
		try(Connection connection=DataBaseConnectionUtils.createConnection())
		{
			//create the statement object
			Statement statement = connection.createStatement();
			//execute the query
			result = statement.executeUpdate("drop table Employee");
		}
		catch(SQLException e)
		{	e.printStackTrace();
		}
		return result;
	}
}








