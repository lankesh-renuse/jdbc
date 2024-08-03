package com.sit.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	static Connection con = null ;
	static PreparedStatement stm = null ;
	
	public static Connection createConnection() {

		try {
			
			FileInputStream fis = new FileInputStream("application.properties");
			
			Properties p = new Properties();
			p.load(fis);
			
			String url = (String) p.get("url");
			String username = (String) p.get("username") ;
			String password = (String) p.get("password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url , username , password);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con ;
	}
	
	public static void closeConnections() {
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
