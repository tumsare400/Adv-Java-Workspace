package com.capgemini.lambda.model;

import java.util.Objects;



public class Employee {
	private int employeeID;
	private String employeeName;
	private String employeeDepartment;
	private double employeeSalary;

	public Employee() {
		super();

	}

	public Employee(int employeeID, String employeeName, String employeeDepartment, double employeeSalary) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeSalary = employeeSalary;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
  @Override
  public boolean equals(Object obj) {
	  if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(obj instanceof Employee) {
			return false;
		}
		
		
		Employee employees = (Employee) obj;
		if(this.employeeID==employees.employeeID && this.employeeName==employees.employeeName) {
			return true;
		}
	
		return false;
	}
  
  @Override
	public int hashCode() {
		return Objects.hash(employeeID, employeeName);
	}

  @Override
  public String toString() {
	return employeeID+" "+employeeName;
	  
  }
  }

