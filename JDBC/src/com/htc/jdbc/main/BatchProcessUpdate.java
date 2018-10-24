package com.htc.jdbc.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.htc.jdbc.utils.DBConnector;

public class BatchProcessUpdate {
public static void main(String[] args) /*testing only*/throws SQLException, FileNotFoundException, IOException {
	Connection con=DBConnector.getConnection();
	PreparedStatement pstmt=con.prepareStatement("UPDATE employees SET empName=?,designation=?,salary=? WHERE empId=?");
	pstmt.setInt(4, 120);
	pstmt.setString(1, "Updated");
	pstmt.setString(2,"updated");
	pstmt.setDouble(3,123456);
	
	pstmt.addBatch();
	
	pstmt.setInt(4, 121);
	pstmt.setString(1, "Updated");
	pstmt.setString(2,"updated");
	pstmt.setDouble(3,123456);
	
	pstmt.addBatch();
	
	pstmt.setInt(4, 122);
	pstmt.setString(1, "Updated");
	pstmt.setString(2,"updated");
	pstmt.setDouble(3,123456);
	
	pstmt.addBatch();
	
	int[] updateCount=pstmt.executeBatch();
	for(int i:updateCount)
		System.out.println(i);
	
	/*CallableStatement cstmt = con.prepareCall("{?=call updateEmployee(?,?,?,?)}");

	cstmt.registerOutParameter(1, Types.BOOLEAN);
	cstmt.setInt(2, 120);
	cstmt.setString(3,"updated");
	cstmt.setString(4,"updated");
	cstmt.setDouble(5,123456);
	cstmt.addBatch();

	cstmt.registerOutParameter(1, Types.BOOLEAN);
	cstmt.setInt(2, 121);
	cstmt.setString(3,"updated");
	cstmt.setString(4,"updated");
	cstmt.setDouble(5,123456);
	cstmt.addBatch();

	cstmt.registerOutParameter(1, Types.BOOLEAN);
	cstmt.setInt(2, 122);
	cstmt.setString(3,"updated");
	cstmt.setString(4,"updated");
	cstmt.setDouble(5,123456);
	cstmt.addBatch();
	
	int[] updateCount=	cstmt.executeBatch();
*/	
	pstmt.close();
	con.close();

}
}
