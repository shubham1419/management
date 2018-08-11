package com.shubham.projectmanagement.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.projectmanagement.dao.ProjectsMetaDao;
import com.shubham.projectmanagement.dto.ProjectsMeta;

@Repository("projectsMetaDao")
@Transactional
public class ProjectsMetaDaoImpl implements ProjectsMetaDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public ProjectsMeta get(int id) {
		try
		{
			return sessionFactory.getCurrentSession().get(ProjectsMeta.class, Integer.valueOf(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ProjectsMeta> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM ProjectsMeta where id!= 0", ProjectsMeta.class).getResultList();

	}

	@Override
	public boolean add(ProjectsMeta projectsMeta) {
		try
		{
			sessionFactory.getCurrentSession().persist(projectsMeta);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(ProjectsMeta projectsMeta) {
		try
		{
			sessionFactory.getCurrentSession().update(projectsMeta);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean softDelete(ProjectsMeta projectsMeta) {
		projectsMeta.setStatus(false);
		try
		{
			sessionFactory.getCurrentSession().update(projectsMeta);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean hardDelete(ProjectsMeta projectsMeta) {
		try
		{
			sessionFactory.getCurrentSession().delete(projectsMeta);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
