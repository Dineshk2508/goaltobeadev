package com.htc.jdbc.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.htc.jdbc.dao.IEmployeeServiceProviderImpl;
import com.htc.jdbc.dto.Employee;

public class Main {
	public static void main(String[] args) {
		IEmployeeServiceProviderImpl impl=new IEmployeeServiceProviderImpl();
		
		try {
			
			// insert Employee
			/*boolean insertResult=impl.saveEmployee(new Employee(100,"Thomas","Tester",2000.00));
			System.out.println(insertResult);*/
			
			// getemployee with empId
			/*Employee emp=impl.getEmployee(100);
			System.out.println(emp.toString());*/
			
			// Delete Employee record with empid
			//System.out.println("Delete Result: "+impl.deleteEmployee(100));
			
			//update employee
			/*
			Employee emp=impl.getEmployee(126);
			emp.setEmpName("Priyanka");
			emp.setDesignation("Manager");
			emp.setSalary(7054674.00);
			
			System.out.println("update Result: "+impl.updateEmployee(126,emp));
			*/
			
			// get all employees record
			for(Employee emp:impl.getEmployees())
				System.out.println(emp.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
