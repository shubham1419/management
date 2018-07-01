package com.shubham.projectmanagement.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.projectmanagement.dao.ProjectDao;
import com.shubham.projectmanagement.dto.Project;

@Repository("projectDao")
@Transactional
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Project get(int id) {
		return sessionFactory.getCurrentSession().get(Project.class, Integer.valueOf(id));
	}

	@Override
	public List<Project> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Project project) {
		try{
			sessionFactory.getCurrentSession().persist(project);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Project project) {
		try{
			sessionFactory.getCurrentSession().update(project);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean softDelete(Project project) {
		project.setStatus(false);
		try{
			sessionFactory.getCurrentSession().update(project);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean hardDelete(Project project) {
		try{
			sessionFactory.getCurrentSession().delete(project);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
