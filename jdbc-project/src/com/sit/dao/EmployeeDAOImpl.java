package com.sit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sit.entity.Employee;
import com.sit.util.JDBCUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Employee s) {
		Connection con = null ;
		PreparedStatement stm = null ;
		
		try {
			String Query = "insert into employee(name , age , salary) values (? , ? , ?)" ;
			
			con = JDBCUtil.createConnection();
			
			// stm = con.createStatement();
			
			stm = con.prepareStatement(Query);
			stm.setString(1,s.getName());
			stm.setInt(2, s.getAge());
			stm.setDouble(3, s.getSalary());
			
			int row = stm.executeUpdate();
			
			if (row > 0) {
				System.out.println("data inserted successfully");
			} else {
				System.err.println("data not inserted");
			}
			// ResultSet executeQuery() - select , int executeUpdate() - create , drop , insert , update delete , alter
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnections();
		}
	}

	@Override
	public void update(int id, double salary) {
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
				System.out.println("data updated successfully");
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

	@Override
	public void delete(int id) {
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
				System.out.println("data deleted successfully");
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

	@Override
	public List<Employee> fetch() {
		Connection con = null ;
		PreparedStatement stm = null ;
		List<Employee> l = new ArrayList<Employee>();
		try {
			String Query = "select * from employee" ;
			con = JDBCUtil.createConnection();
			
			// stm = con.createStatement();
			
			stm = con.prepareStatement(Query);
			
			ResultSet result = stm.executeQuery();
			
			while(result.next()) {
				l.add(new Employee(result.getInt("id"),result.getString("name"), result.getInt("age"), result.getDouble("salary")));
//				System.out.println(result.getString("name"));
//				System.out.println(result.getInt("age"));
//				System.out.println(result.getDouble("salary"));
//				System.out.println("--------------------------------");
			}
			
			// ResultSet executeQuery() - select , int executeUpdate() - create , drop , insert , update delete , alter
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnections();
		}
		return l;
	}

}
