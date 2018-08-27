package com.shubham.projectmanagement.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.projectmanagement.dao.EmployeeDao;
import com.shubham.projectmanagement.dto.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Employee get(int id) {
		try{
			return sessionFactory.getCurrentSession().get(Employee.class, Integer.valueOf(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> list() {
		return sessionFactory.getCurrentSession().createQuery("from Employee where id!= 0", Employee.class).getResultList();
	}

	@Override
	public boolean add(Employee employee) {
		try
		{
			 sessionFactory.getCurrentSession().persist(employee);
			 return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Employee employee) {
		try
		{
			sessionFactory.getCurrentSession().update(employee);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean softDelete(Employee employee) {
		employee.setStatus(false);
		try
		{
			sessionFactory.getCurrentSession().update(employee);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean hardDelete(Employee employee) {
		try
		{
			sessionFactory.getCurrentSession().delete(employee);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Employee getByEmail(String email) {
		try 
		{
			String query = "From Employee where email=:email";
			return sessionFactory.getCurrentSession().createQuery(query,Employee.class).setParameter("email",email).getSingleResult();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;	
		}
}

}
