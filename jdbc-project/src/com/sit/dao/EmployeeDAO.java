package com.sit.dao;

import com.sit.entity.Employee;

public interface EmployeeDAO extends DAO<Employee> {
	Employee get(int id);
	
	
}
