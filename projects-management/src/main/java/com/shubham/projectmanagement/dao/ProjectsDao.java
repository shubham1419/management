package com.shubham.projectmanagement.dao;

import java.util.List;

import com.shubham.projectmanagement.dto.Projects;

public interface ProjectsDao {
	
	Projects get(int id);
	List<Projects> list();
	boolean add(Projects projects);
	boolean update(Projects projects);
	boolean softDelete(Projects projects);
	boolean hardDelete(Projects projects);

}
