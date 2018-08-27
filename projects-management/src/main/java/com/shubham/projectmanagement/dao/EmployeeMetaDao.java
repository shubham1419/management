package com.shubham.projectmanagement.dao;

import java.util.List;

import com.shubham.projectmanagement.dto.EmployeeMeta;

public interface EmployeeMetaDao {
	EmployeeMeta get(int id);
	EmployeeMeta getSingle(int id);
	List<EmployeeMeta> list();
	boolean add(EmployeeMeta employeeMeta);
	boolean update(EmployeeMeta employeeMeta);
	boolean softDelete(EmployeeMeta employeeMeta);
	boolean hardDelete(EmployeeMeta employeeMeta);

}
