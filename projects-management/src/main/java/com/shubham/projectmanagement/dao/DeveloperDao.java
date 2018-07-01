package com.shubham.projectmanagement.dao;

import java.util.List;

import com.shubham.projectmanagement.dto.Developer;

public interface DeveloperDao {

	Developer get(int id);
	List<Developer> list();
	boolean add(Developer developer);
	boolean update(Developer developer);
	boolean softDelete(Developer developer);
	boolean hardDelete(Developer developer);
	
}
