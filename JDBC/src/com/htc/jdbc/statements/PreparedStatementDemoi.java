package com.htc.jdbc.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemoi {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://172.16.50.14:5432/corejava","postgres","password@123");
			/*
			String sqlQuery="INSERT INTO Employees VALUES(?,?,?,?)"; 
			PreparedStatement pstmt=con.prepareStatement(sqlQuery);
			
			pstmt.setInt(1, 126);
			pstmt.setString(2, "Gopi");
			pstmt.setString(3, "Trainer");
			pstmt.setDouble(4, 2000.00);
			
			boolean insertResult=pstmt.execute();
			System.out.println("insert result: "+!insertResult );
			*/

			//PreparedStatement pstmt=con.prepareStatement("SELECT empId,empName,designation,salary FROM employees where salary>?");
			//PreparedStatement pstmt=con.prepareStatement("SELECT empId,empName,designation,salary FROM employees where empId=?");
			//PreparedStatement pstmt=con.prepareStatement("DELETE FROM employees WHERE empId=?");
			PreparedStatement pstmt=con.prepareStatement("UPDATE Employees set salary=? WHERE empId=? AND empName=?");
			pstmt.setInt(2, 124);
			pstmt.setDouble(1, 123456.00);
			pstmt.setString(3, "Ashok");
			System.out.println("Update result: "+!pstmt.execute());
			//System.out.println("Delete result: " +!pstmt.execute());
			// result set for select queries
			/*ResultSet rs=pstmt.executeQuery();
			   rs.next();  // mvoe the control to our first record
				System.out.println(rs.getInt("empId"));
				System.out.println(rs.getString("empName"));
				System.out.println( rs.getString("designation"));
				System.out.println(rs.getDouble("salary"));
				System.out.println("============================" );
			*/
			
			
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
