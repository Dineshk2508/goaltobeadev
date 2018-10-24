package com.htc.jdbc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.htc.jdbc.dto.Employee;

public interface IEmployeeServiceProvider {

	// returns one employee record
	public Employee getEmployee(int empId) throws FileNotFoundException, IOException, SQLException;
	// returns all the employee records in the table
	public ArrayList<Employee> getEmployees() throws FileNotFoundException, IOException, SQLException;
	// insert one employee record to a table
	public boolean saveEmployee(Employee emp) throws FileNotFoundException, IOException, SQLException;
	// delete one record from employee table
	public boolean deleteEmployee(int empId) throws FileNotFoundException, IOException, SQLException;
	// update the employee record based on the given data
	public boolean updateEmployee(int empId,Employee updatedEmployee) throws FileNotFoundException, IOException, SQLException;
}
