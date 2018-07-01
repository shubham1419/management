package com.shubham.projectmanagement.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.projectmanagement.dao.TaskDao;
import com.shubham.projectmanagement.dto.Task;

@Repository("taskDao")
@Transactional
public class TaskDaoImpl implements TaskDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Task get(int id) {
		
		return sessionFactory.getCurrentSession().get(Task.class, Integer.valueOf(id));
	}

	@Override
	public List<Task> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Task task) {
		try{
			sessionFactory.getCurrentSession().persist(task);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Task task) {
		try{
			sessionFactory.getCurrentSession().update(task);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean softDelete(Task task) {
		task.setStatus(false);
		try{
			sessionFactory.getCurrentSession().update(task);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean hardDelete(Task task) {
		try{
			sessionFactory.getCurrentSession().delete(task);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
