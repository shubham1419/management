package com.shubham.projectmanagement.dao;

import java.util.List;

import com.shubham.projectmanagement.dto.ProjectsMeta;

public interface ProjectsMetaDao {
	
	ProjectsMeta get(int id);
	List<ProjectsMeta> list();
	boolean add(ProjectsMeta projectsMeta);
	boolean update(ProjectsMeta projectsMeta);
	boolean softDelete(ProjectsMeta projectsMeta);
	boolean hardDelete(ProjectsMeta projectsMeta);

}
