package com.shubham.projectmanagement.dao;

import java.util.List;

import com.shubham.projectmanagement.dto.Project;

public interface ProjectDao {

	Project get(int id);
	List<Project> list();
	boolean add(Project project);
	boolean update(Project project);
	boolean softDelete(Project project);
	boolean hardDelete(Project project);
}
