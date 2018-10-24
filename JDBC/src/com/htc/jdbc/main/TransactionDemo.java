package com.htc.jdbc.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.htc.jdbc.utils.DBConnector;

public class TransactionDemo {
	public static void main(String[] args) {
		Connection con = null;
		Savepoint insertSavepoint = null;
		try {
			con = DBConnector.getConnection();
			con.setAutoCommit(false);
			//insertSavepoint = con.setSavepoint("beforeInsert");
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO Employees values(?,?,?,?)");
			pstmt.setInt(1, 220);
			pstmt.setString(2, "newemployee");
			pstmt.setString(3, "newDesignation");
			pstmt.setDouble(4, 1000.00);
			pstmt.execute();
			con.commit();		
			insertSavepoint = con.setSavepoint("afterInsert");
			pstmt = con.prepareStatement("INSERTs INTO Employees values(?,?,?,?)");
			pstmt.setInt(1, 223);
			pstmt.setString(2, "newemployee");
			pstmt.setString(3, "newDesignation");
			pstmt.setDouble(4, 1000.00);
			pstmt.execute();

			con.commit();
		} catch (SQLException | IOException e) {
			try {
				con.rollback(insertSavepoint);
				//con.rollback();
				System.out.println("Transaction Failed: " + e.getMessage());
			} catch (SQLException e1) {
				
				System.out.println("rollback Error: "+e1.getMessage());
			}
		}

	}
}
