package com.shubham.projectmanagement.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String role;
	private String designation;
	private boolean assigned;
	private boolean status;
	
	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL )
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
