package com.htc.jdbc.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;

import com.htc.jdbc.dto.Employee;
import com.htc.jdbc.utils.DBConnector;

public class ScrollableResultSetDemo {
public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
	Connection con=DBConnector.getConnection();
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
	ResultSet rs=stmt.executeQuery("SELECT empId,empName,designation,salary FROM Employees ORDER BY salary DESC");
	
	/*while(rs.next()) */{
		//rs.absolute(3);
		
		rs.last();
		//rs.first();
		Employee emp=new Employee();
		emp.setEmpId(rs.getInt("empId"));
		emp.setEmpName(rs.getString("empName"));
		emp.setDesignation(rs.getString("designation"));
		
		rs.updateDouble("salary", rs.getDouble("salary")+10000.00);
		rs.updateRow();
		emp.setSalary(rs.getDouble("salary"));
		
		System.out.println(emp);
		
		/*rs.relative(+2);  //3+2 =5
		
		emp=new Employee();
		emp.setEmpId(rs.getInt("empId"));
		emp.setEmpName(rs.getString("empName"));
		emp.setDesignation(rs.getString("designation"));
		emp.setSalary(rs.getDouble("salary"));
		
		System.out.println(emp);*/
		
		
		
	}
	
}
}
