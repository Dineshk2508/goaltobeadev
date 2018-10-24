package com.htc.jdbc.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.htc.jdbc.utils.DBConnector;

public class BatchProcessingTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Connection con = DBConnector.getConnection();

		PreparedStatement pstmt = con.prepareStatement("INSERT INTO Employees VALUES(?,?,?,?)");
		pstmt.setInt(1, 120);
		pstmt.setString(2, "Krish");
		pstmt.setString(3, "Program Analyst");
		pstmt.setDouble(4, 40000.00);
		
		pstmt.addBatch();  // add an insert query with the above properties in a batch

		pstmt.setInt(1, 121);
		pstmt.setString(2, "Rajesh");
		pstmt.setString(3, "Trainer");
		pstmt.setDouble(4, 2000.00);
		
		pstmt.addBatch();

		pstmt.setInt(1, 122);
		pstmt.setString(2, "Karthick");
		pstmt.setString(3, "Asst Manager");
		pstmt.setDouble(4, 65000.00);
		
		pstmt.addBatch();

		int[] updateCounts = pstmt.executeBatch();
		for (int i : updateCounts)
			System.out.println(i);

		pstmt.close();
		con.close();
	}
}
