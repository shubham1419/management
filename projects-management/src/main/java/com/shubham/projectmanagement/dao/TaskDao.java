package com.shubham.projectmanagement.dao;

import java.util.List;

import com.shubham.projectmanagement.dto.Task;

public interface TaskDao {
	
	Task get(int id);
	List<Task> list();
	boolean add(Task task);
	boolean update(Task task);
	boolean softDelete(Task task);
	boolean hardDelete(Task task);

}
