package com.shubham.projectmanagement.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.projectmanagement.dao.ProjectsDao;
import com.shubham.projectmanagement.dto.Projects;

@Repository("projectsDao")
@Transactional
public class ProjectsDaoImpl implements ProjectsDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public Projects get(int id) {
		try
		{
			return sessionFactory.getCurrentSession().get(Projects.class, Integer.valueOf(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Projects> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Projects where id!= 0", Projects.class).getResultList();
	}

	@Override
	public boolean add(Projects projects) {
		try
		{
			sessionFactory.getCurrentSession().persist(projects);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Projects projects) {
		try
		{
			sessionFactory.getCurrentSession().update(projects);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean softDelete(Projects projects) {
		projects.setStatus(false);
		try
		{
			sessionFactory.getCurrentSession().update(projects);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean hardDelete(Projects projects) {
		try
		{
			sessionFactory.getCurrentSession().delete(projects);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
