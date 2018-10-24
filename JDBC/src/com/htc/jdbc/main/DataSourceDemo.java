package com.htc.jdbc.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;

public class DataSourceDemo {

	public static void main(String[] args) {
		try {
			Context context=new InitialContext();
			ConnectionPoolDataSource ds=(ConnectionPoolDataSource) context.lookup("java:/comp/env/jdbc/pgsql");
			PooledConnection pc=ds.getPooledConnection();
			Connection con=pc.getConnection();
			ResultSet rs=con.createStatement().executeQuery("select * from employees");
					while(rs.next()) {
						System.out.println(rs.getString("empName"));
					}
			
		} catch (NamingException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
