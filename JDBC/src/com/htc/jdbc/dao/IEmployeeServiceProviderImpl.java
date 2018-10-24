package com.htc.jdbc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.htc.jdbc.dto.Employee;
import com.htc.jdbc.utils.DBConnector;

public class IEmployeeServiceProviderImpl implements IEmployeeServiceProvider {

	
	@Override
	public Employee getEmployee(int empId) throws FileNotFoundException, IOException, SQLException {
		Employee emp=null;
		Connection con=DBConnector.getConnection();
		CallableStatement cstmt=con.prepareCall("{call readEmployee(?,?,?,?)}");
		cstmt.setInt(1, empId);
		cstmt.registerOutParameter(2, Types.CHAR);
		cstmt.registerOutParameter(3, Types.CHAR);
		cstmt.registerOutParameter(4, Types.DOUBLE);
		cstmt.execute();
		
		emp=new Employee(empId,cstmt.getString(2),cstmt.getString(3),cstmt.getDouble(4));
		
		
		return emp;
	}

	@Override
	public ArrayList<Employee> getEmployees() throws FileNotFoundException, IOException, SQLException {
		ArrayList<Employee> employees=new ArrayList<>();
		Connection con=DBConnector.getConnection();
		CallableStatement cstmt=con.prepareCall("{call readEmployees()}");
		ResultSet rs=cstmt.executeQuery();
		while(rs.next()) {
			Employee emp=new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("design"),rs.getDouble("sal"));
			employees.add(emp);
		}
		return employees;
	}

	@Override
	public boolean saveEmployee(Employee emp) throws FileNotFoundException, IOException, SQLException {
		boolean insertFlag=false;
		Connection con=DBConnector.getConnection();
		CallableStatement cstmt=con.prepareCall("{?=call insertEmployee(?,?,?,?)}");
		
		cstmt.registerOutParameter(1, Types.BOOLEAN);
		
		cstmt.setInt(2, emp.getEmpId());
		cstmt.setString(3, emp.getEmpName());
		cstmt.setString(4, emp.getDesignation());
		cstmt.setDouble(5,emp.getSalary());
		
		cstmt.execute();
		insertFlag=cstmt.getBoolean(1);
		return insertFlag;
	}

	@Override
	public boolean deleteEmployee(int empId) throws FileNotFoundException, IOException, SQLException {
		boolean deleteFlag=false;
		Connection con=DBConnector.getConnection();
		CallableStatement cstmt=con.prepareCall("{?=call deleteEmployee(?)}");
		cstmt.registerOutParameter(1, Types.BOOLEAN);
		cstmt.setInt(2,empId);
		cstmt.execute();
		deleteFlag=cstmt.getBoolean(1);
		return deleteFlag;
	}

	@Override
	public boolean updateEmployee(int empId, Employee updatedEmployee)
			throws FileNotFoundException, IOException, SQLException {
		boolean updateFlag=false;
		Connection con=DBConnector.getConnection();
		CallableStatement cstmt=con.prepareCall("{?=call updateEmployee(?,?,?,?)}");
		if(empId==updatedEmployee.getEmpId()) {
		cstmt.setInt(2, empId);
		cstmt.setString(3, updatedEmployee.getEmpName());
		cstmt.setString(4, updatedEmployee.getDesignation());
		cstmt.setDouble(5, updatedEmployee.getSalary());
		
		cstmt.registerOutParameter(1, Types.BOOLEAN);
		}
		cstmt.execute();
		updateFlag=cstmt.getBoolean(1);
		
		return updateFlag;
	}

}
