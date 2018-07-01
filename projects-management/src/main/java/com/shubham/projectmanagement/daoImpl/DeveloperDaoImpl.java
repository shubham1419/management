package com.shubham.projectmanagement.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.projectmanagement.dao.DeveloperDao;
import com.shubham.projectmanagement.dto.Developer;

@Repository("developerDao")
@Transactional
public class DeveloperDaoImpl implements DeveloperDao {

	@Autowired
	SessionFactory sessionFactory;
	
	private static List<Developer> devlopers = new ArrayList<>();
	
	static{
		
		Developer developer = new Developer();
		
		developer.setId(1);
		developer.setName("DName");
		developer.setAddress("Address1");
		developer.setDesignation("Designation1");
		developer.setEmail("email1");
		developer.setPassword("pass");
		developer.setPhone("12345");
		developer.setRole("Team Lead");
		developer.setStatus(true);
		
		devlopers.add(developer);
		
		developer.setId(2);
		developer.setName("DName2");
		developer.setAddress("Address2");
		developer.setDesignation("Designation2");
		developer.setEmail("email2");
		developer.setPassword("pass2");
		developer.setPhone("12345586");
		developer.setRole("Team Lead2");
		developer.setStatus(true);
		
		devlopers.add(developer);
		
	}
	
	/*for getting single category by id*/
	public Developer get(int id) {
		return sessionFactory.getCurrentSession().get(Developer.class,Integer.valueOf(id));
	}

	public List<Developer> list() {
		// TODO Auto-generated method stub
		return devlopers;
	}

	public boolean add(Developer developer) {
		try
		{
			sessionFactory.getCurrentSession().persist(developer);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Developer developer) {
		try
		{
			sessionFactory.getCurrentSession().update(developer);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean softDelete(Developer developer) {
		developer.setStatus(false);
		try
		{
			sessionFactory.getCurrentSession().update(developer);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean hardDelete(Developer developer) {
		try
		{
			sessionFactory.getCurrentSession().delete(developer);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
