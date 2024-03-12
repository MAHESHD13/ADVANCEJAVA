package com.advjava.jdbc;

import java.util.List;

public class EmployeeMain_01 
{
	public static void main(String[] args) 
	{
		EmployeeDao dao=new EmployeeDao();
		int createResult = dao.createTable();
		System.out.println("Table Creation Status..."+createResult);
	}
}
class EmployeeMain_02
{
	public static void main(String[] args) 
	{
		EmployeeDao dao=new EmployeeDao();
		Employee emp = new Employee();
		emp.setEmpId("EMP863908");
		emp.setEmpName("Mahesh");
		emp.setEmpSalary(24000.10d);
		int result = dao.saveEmployee(emp);
		if(result == 1)
		{
			System.out.println("Data Inserted Successfully.....");
		}
		else
		{
			System.out.println("Data Insertion Fail Check Once.....");
		}
	}
}
class EmployeeMain_03
{
	public static void main(String[] args) 
	{
		EmployeeDao dao = new EmployeeDao();
		Employee emp = dao.findByEmpId("TMLD900016");
		if(emp != null)
		{
			System.out.println("Employee Data is Available...");
			System.out.println(emp.getEmpId()+"---"+emp.getEmpName()+"---"+emp.getEmpSalary());
		}
		else 
		{
			System.out.println("Employee Data is Not Available...");
		}	
	}
}
class EmployeeMain_04
{
	public static void main(String[] args) 
	{
		EmployeeDao dao = new EmployeeDao();
		List<Employee> employees =dao.findAll();
		employees.forEach(employee->System.out.println(employee));
	}
}
class EmployeeMain_05
{
	public static void main(String[] args) 
	{
		EmployeeDao dao = new EmployeeDao();
		int count = dao.updateEmployee(30000,1000);
		System.out.println("Updated Records Count..."+count);
		
	}
}
class EmployeeMain_06 {
	public static void main(String[] args) { 
		EmployeeDao dao = new EmployeeDao();
		int count = dao.deleteByEmpId("TMLD900016");
		System.out.println("delete records count.."+count);
	}
}
class EmployeeMain_07 {
	public static void main(String[] args) { 
		EmployeeDao dao = new EmployeeDao();
		int count = dao.deleteByEmpSalary(26000);
		System.out.println("deleate records count.."+count);
	}
}
class EmployeeMain_08 {
	public static void main(String[] args) { 
		EmployeeDao dao = new EmployeeDao();
		int count = dao.dropTable();
		System.out.println("Table is dropped status...."+count);
	}
}


























