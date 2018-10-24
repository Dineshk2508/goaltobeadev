package com.htc.jdbc.statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementDemo {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:postgresql://172.16.50.14:5432/corejava","postgres","password@123");
			CallableStatement cstmt=con.prepareCall("{?=Call insertEmployee(?,?,?,?)}");
			cstmt.registerOutParameter(1, Types.BOOLEAN);
			cstmt.setInt(2, 126);
			cstmt.setString(3, "Charles");
			cstmt.setString(4, "Admin");
			cstmt.setDouble(5, 1000.00);
			
			cstmt.execute();
			
			System.out.println("insert result: "+cstmt.getBoolean(1));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
