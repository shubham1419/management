package com.shubham.projectmanagement.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.projectmanagement.configuration.HibernateConfig;
import com.shubham.projectmanagement.dao.EmployeeDao;
import com.shubham.projectmanagement.dao.EmployeeMetaDao;
import com.shubham.projectmanagement.dto.Employee;
import com.shubham.projectmanagement.dto.EmployeeMeta;


public class EmployeeTestCase {
	private static EmployeeDao employeeDao; 
	private static EmployeeMetaDao employeeMetaDao;
	
	
	private static AnnotationConfigApplicationContext context;
	
	private Employee employee;
	private EmployeeMeta employeeMeta;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(HibernateConfig.class);

		employeeDao = context.getBean(EmployeeDao.class);
		employeeMetaDao = context.getBean(EmployeeMetaDao.class);
	}
	
	@Test
	public void addEmployeeWithMeta()
	{
		employeeMeta = new EmployeeMeta();
		employeeMeta = employeeMetaDao.getSingle(1);
		assertEquals("Failed to get Single result", "user", employeeMeta.getFisrtName());
		//for add
		/*employee = new Employee();
		employeeMeta = new EmployeeMeta();
		
		employee.setDesignation("Team Lead");
		employee.setAssigned(true);
		employee.setRole("Developer");
		employee.setStatus(true);
		
		employeeMeta.setFisrtName("Shubham");
		employeeMeta.setLastName("Gupta");
		employeeMeta.setAddress("Mathura");
		employeeMeta.setPhone("123456");
		employeeMeta.setStatus(true);
		employeeMeta.setEmployee(employee);
		
		employee.setEmployeeMeta(employeeMeta);
		
		assertEquals("Failed to add", true, employeeDao.add(employee));
		//work on both employee and its child employeemeta
		
		//for Read
		employee = employeeDao.get(20);
		assertEquals("Failed to read", "Team Lead", employee.getDesignation());
		
		//for update
		employee = employeeDao.get(20);
		employee.setStatus(true);
		assertEquals("Failed to update", true, employeeDao.update(employee));
		
		//for soft delete
		employee = employeeDao.get(20);
		employee.setStatus(false);
		assertEquals("Failed to update", true, employeeDao.softDelete(employee));
		
		//for hard delete
		employee = employeeDao.get(22);
		assertEquals("Failed to update", true, employeeDao.hardDelete(employee));
		//work on both employee and its child employeemeta
		 * */
		
	}	
}
