package com.capgemini.lambda.client;

import java.util.Comparator;
import java.util.TreeSet;

import com.capgemini.lambda.model.Employee;

public class EmployeeClient {

	public static void main(String[] args) {
		Comparator<Employee> c=(e1, e2)->Integer.compare(e1.getEmployeeID(), e2.getEmployeeID());
	    
		Comparator<Employee>c2=(e1,e2)->{
			int result=Double.compare(e1.getEmployeeID(), e2.getEmployeeID());
			if(result==0)
				result=Integer.compare(e1.getEmployeeID(), e2.getEmployeeID());
			return result;
		
	};


		TreeSet<Employee> employees = new TreeSet<>(e1,e2)->Integer.compare(e1.getEmployeeID(), e2.getEmployeeID());

		employees.add(new Employee(101, "Alex", "HR", 34000));
		employees.add(new Employee(56, "Grant", "Admin", 12000));
		employees.add(new Employee(88, "Bob", "Admin", 56000));
		employees.add(new Employee(12, "Taylor", "HR", 12000));
		
		for(Employee employee:employees) {
			System.out.println(employee);
		}
	}}

