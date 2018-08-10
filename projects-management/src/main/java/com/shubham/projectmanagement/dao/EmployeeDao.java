package com.shubham.projectmanagement.dao;

import java.util.List;

import com.shubham.projectmanagement.dto.Employee;

public interface EmployeeDao {

	Employee get(int id);
	List<Employee> list();
	boolean add(Employee employee);
	boolean update(Employee employee);
	boolean softDelete(Employee employee);
	boolean hardDelete(Employee employee);
}
