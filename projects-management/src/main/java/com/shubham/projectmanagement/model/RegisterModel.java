package com.shubham.projectmanagement.model;

import java.io.Serializable;

import com.shubham.projectmanagement.dto.Employee;
import com.shubham.projectmanagement.dto.EmployeeMeta;

public class RegisterModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private EmployeeMeta employeeMeta;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public EmployeeMeta getEmployeeMeta() {
		return employeeMeta;
	}
	public void setEmployeeMeta(EmployeeMeta employeeMeta) {
		this.employeeMeta = employeeMeta;
	}
	
	
}
