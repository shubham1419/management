package com.shubham.projectmanagement.dto;

import javax.persistence.OneToOne;

public class Employee {
	private int id;
	private String role;
	private String designation;
	private boolean assigned;
	private boolean status;
	
	@OneToOne
	private EmployeeMeta employeeMeta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public EmployeeMeta getEmployeeMeta() {
		return employeeMeta;
	}

	public void setEmployeeMeta(EmployeeMeta employeeMeta) {
		this.employeeMeta = employeeMeta;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", role=" + role + ", designation=" + designation + ", assigned=" + assigned
				+ ", status=" + status + ", employeeMeta=" + employeeMeta + "]";
	}

}
