package com.shubham.projectmanagement.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String role;
	private String designation;
	private String email;
	private boolean assigned;
	private boolean status = true;
	private String password;
	@Transient
	private String confirmPassword;
	
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", role=" + role + ", designation=" + designation + ", email=" + email
				+ ", assigned=" + assigned + ", status=" + status + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", employeeMeta=" + employeeMeta + "]";
	}

	

	
}
