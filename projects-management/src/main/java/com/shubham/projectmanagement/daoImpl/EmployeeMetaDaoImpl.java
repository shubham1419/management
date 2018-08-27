package com.shubham.projectmanagement.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.projectmanagement.dao.EmployeeMetaDao;
import com.shubham.projectmanagement.dto.EmployeeMeta;

@Repository("employeeMetaDao")
@Transactional
public class EmployeeMetaDaoImpl implements EmployeeMetaDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public EmployeeMeta get(int id) {
		try{
			return sessionFactory.getCurrentSession().get(EmployeeMeta.class,Integer.valueOf(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public EmployeeMeta getSingle(int id) {
		try{
			String query = "FROM EmployeeMeta where employee_id = :id";
			return sessionFactory.getCurrentSession().createQuery(query, EmployeeMeta.class ).setParameter("id",id).getSingleResult();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmployeeMeta> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM EmployeeMeta where id!= 0", EmployeeMeta.class ).getResultList();
	}

	@Override
	public boolean add(EmployeeMeta employeeMeta) {
		try
		{
			sessionFactory.getCurrentSession().persist(employeeMeta);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(EmployeeMeta employeeMeta) {
		try
		{
			sessionFactory.getCurrentSession().update(employeeMeta);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean softDelete(EmployeeMeta employeeMeta) {
		employeeMeta.setStatus(false);
		try
		{
			sessionFactory.getCurrentSession().update(employeeMeta);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean hardDelete(EmployeeMeta employeeMeta) {
		try
		{
			sessionFactory.getCurrentSession().delete(employeeMeta);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
