package com.sit.client;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.sit.dao.EmployeeDAOImpl;
import com.sit.entity.Employee;

public class TestJDBC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDAOImpl obj = new EmployeeDAOImpl();
//		Employee e = new Employee("kiran", 45, 23344);
//		obj.save(e);
		
		int ch = 0;
		while(true) {
			System.out.print("\n1. Insert Data"
					+ "\n2. Update Data"
					+ "\n3. Delete Data"
					+ "\n4. View data"
					+ "\n5. Exit"
					+ "\nEnter choice: ");
			ch = sc.nextInt();
//			sc.next();
			switch(ch) {
			case 1:
				System.err.print("\nEnter emp( Name, Age, Salary):");
				obj.save(new Employee(sc.next(), sc.nextInt(), sc.nextDouble()));
				break;
			case 2:
				System.out.print("\nEnter (id, Salary): ");
				obj.update(sc.nextInt(), sc.nextDouble());
				break;
			case 3:
				System.err.print("\nEnter emp id : ");
				obj.delete(sc.nextInt());
				break;
			case 4:
				List<Employee> le = obj.fetch();
				Iterator <Employee> i = le.iterator();
				while(i.hasNext()) {
					Employee e = i.next();
					System.out.printf("%d -> Name : %s, Age : %d, Salary : %f\n",e.getId(), e.getName(),e.getAge(),e.getSalary());
				}
				break;
			case 5:
				System.out.println("Exiting.....");
				System.exit(0);
			default:
				System.err.println("\nEnter valid option");
			}
		}
	}
}
