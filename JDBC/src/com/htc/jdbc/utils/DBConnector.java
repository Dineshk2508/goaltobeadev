package com.htc.jdbc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		Connection con=null;
		Properties prop=new Properties();
		prop.load(new FileInputStream("PostgreSQLProperties.properties"));
		String URL=prop.getProperty("DBProvider")+"://"
						+prop.getProperty("serverIP")+":"
						+ prop.getProperty("port")+"/"+prop.getProperty("DBName");
		
		con=DriverManager.getConnection(URL,prop.getProperty("userName"),prop.getProperty("password"));
		return con;
	}
}
