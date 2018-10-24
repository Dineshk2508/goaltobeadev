package com.htc.jdbc.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleStatementDemo {

	public static void main(String[] args) {
				try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://172.16.50.14:5432/corejava","postgres","password@123");
			Statement stmt=con.createStatement();
			/*boolean stmtResult=stmt.execute("CREATE TABLE Employees(empId INT PRIMARY KEY,empName CHAR(20),designation CHAR(20),salary decimal(10,2))");
			System.out.println("The result of Statement: "+stmtResult);*/
			
			ResultSet rs=stmt.executeQuery("SELECT empId,empName,designation,salary FROM employees");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println( rs.getString("designation"));
				System.out.println(rs.getDouble("salary"));
				System.out.println("============================" );
			}
			
			
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
