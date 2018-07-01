package com.shubham.projectmanagement.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.projectmanagement.configuration.HibernateConfig;
import com.shubham.projectmanagement.dao.DeveloperDao;
import com.shubham.projectmanagement.dto.Developer;

public class DeveloperTestCase {

	private static DeveloperDao developerDao;

	private static AnnotationConfigApplicationContext context;

	private Developer developer;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(HibernateConfig.class);

		developerDao = context.getBean(DeveloperDao.class);
	}

	/** CRUD Operation **/

	@Test
	// Add
	public void testCrudCategory() {
		// for add/Create
		developer = new Developer();
		// developer.setId(1);
		developer.setName("DName");
		developer.setAddress("Address1");
		developer.setDesignation("Designation1");
		developer.setEmail("email1");
		developer.setPassword("pass");
		developer.setPhone("12345");
		developer.setRole("Team Lead");
		developer.setStatus(true);

		assertEquals("Failed to add", true, developerDao.add(developer));

		// Read
		developer = developerDao.get(2);

		assertEquals("Failed to read", "DName", developer.getName());

		// Update
		developer = developerDao.get(1);
		developer.setName("Shubh");

		assertEquals("Failed to update", true, developerDao.update(developer));

		// SoftDelete
		developer = developerDao.get(3);
		
		assertEquals("Failed to soft delete", true, developerDao.softDelete(developer));

		// HardDelete
		developer = developerDao.get(4);

		assertEquals("Failed to hard delete", true, developerDao.hardDelete(developer));

	}

}
