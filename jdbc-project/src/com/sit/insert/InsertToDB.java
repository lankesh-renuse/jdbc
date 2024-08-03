package com.sit.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.sit.util.JDBCUtil;

public class InsertToDB {
	
	public static void save(String name , int age , double salary) {
		Connection con = null ;
		PreparedStatement stm = null ;
		
		try {
			String Query = "insert into employee(name , age , salary) values (? , ? , ?)" ;
			
			con = JDBCUtil.createConnection();
			
			// stm = con.createStatement();
			
			stm = con.prepareStatement(Query);
			stm.setString(1,name);
			stm.setInt(2, age);
			stm.setDouble(3, salary);
			
			int row = stm.executeUpdate();
			
			if (row > 0) {
				System.out.println("data insert");
			} else {
				System.out.println("data not inserted");
			}
			// ResultSet executeQuery() - select , int executeUpdate() - create , drop , insert , update delete , alter
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnections();
		}
	}
	
	
	public static void update(int id , double salary) {
		Connection con = null ;
		PreparedStatement stm = null ;
		
		try {
			String Query = "update employee set salary = ? where id=?" ;
			con = JDBCUtil.createConnection();
			
			// stm = con.createStatement();
			
			stm = con.prepareStatement(Query);
			stm.setDouble(1, salary);
			stm.setInt(2, id);
			
			int row = stm.executeUpdate();
			
			if (row > 0) {
				System.out.println("data updated");
			} else {
				System.out.println("data not updated");
			}
			// ResultSet executeQuery() - select , int executeUpdate() - create , drop , insert , update delete , alter
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnections();
		}
	
	}
	
	
	public static void delete(int id) {
		Connection con = null ;
		PreparedStatement stm = null ;
		
		try {
			String Query = "delete from employee where id=?" ;
			con = JDBCUtil.createConnection();
			
			// stm = con.createStatement();
			
			stm = con.prepareStatement(Query);
			stm.setInt(1, id);
			
			int row = stm.executeUpdate();
			
			if (row > 0) {
				System.out.println("data deleted");
			} else {
				System.out.println("data not deleted");
			}
			// ResultSet executeQuery() - select , int executeUpdate() - create , drop , insert , update delete , alter
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnections();
		}
	}
	
	
	public static void fetch() {
		Connection con = null ;
		PreparedStatement stm = null ;
		
		try {
			String Query = "select * from employee" ;
			con = JDBCUtil.createConnection();
			
			// stm = con.createStatement();
			
			stm = con.prepareStatement(Query);
			
			ResultSet result = stm.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getString("name"));
				System.out.println(result.getInt("age"));
				System.out.println(result.getDouble("salary"));
				System.out.println("--------------------------------");
			}
			
			// ResultSet executeQuery() - select , int executeUpdate() - create , drop , insert , update delete , alter
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnections();
		}
	}

//	public static void main(String[] args) {
//		 save("nayan" , 28 , 1400);
		// update(3 , 1500);
		// delete(1);
		
//		fetch();
		
//	}

}
