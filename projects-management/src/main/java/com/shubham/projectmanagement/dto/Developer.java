package com.shubham.projectmanagement.dto;


import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Developer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String role;
	private String designation;
	private String imgCode;
	private String password;
	@Transient
	private String confirmPassword;
	@Transient
	private MultipartFile file;
	private String address;
	private String phone;
	private boolean status;
	@ManyToOne
	private Project project;
	//default constructor
	public Developer()
	{
		this.imgCode = "Dev" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", designation="
				+ designation + ", password=" + password + ", address=" + address + ", phone=" + phone + ", status="
				+ status + ", project=" + project + "]";
	}
	
	
	

}
