package com.shubham.projectmanagement.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.projectmanagement.configuration.HibernateConfig;
import com.shubham.projectmanagement.dao.ProjectsDao;
import com.shubham.projectmanagement.dao.ProjectsMetaDao;
import com.shubham.projectmanagement.dto.Projects;
import com.shubham.projectmanagement.dto.ProjectsMeta;

public class ProjectsTestCase {
	
	private static ProjectsDao projectsDao;
	private static ProjectsMetaDao projectsMetaDao;
	
	private static AnnotationConfigApplicationContext context;
	
	private Projects projects;
	private ProjectsMeta projectsMeta;
	private ProjectsMeta projectsMeta2;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		projectsDao = context.getBean(ProjectsDao.class);
		projectsMetaDao = context.getBean(ProjectsMetaDao.class);
		
	}
	
	@Test
	public void projectsMeta()
	{
		projects = new Projects();
		projectsMeta = new ProjectsMeta();
		projectsMeta2 = new ProjectsMeta();
		
		projects.setProjectName("Million Bananas");
		projects.setStatus(true);
		
		projectsMeta.setTaskName("Add Filter Page");
		projectsMeta.setStatus(true);
		projectsMeta.setProjects(projects);
		
		projectsMeta2.setTaskName("Add Service Page");
		projectsMeta2.setStatus(true);
		projectsMeta2.setProjects(projects);
		
		assertEquals("Failed to add projects", true , projectsDao.add(projects));
		assertEquals("Failed to add projectsMeta", true , projectsMetaDao.add(projectsMeta));
		assertEquals("Failed to add projectsMeta1", true , projectsMetaDao.add(projectsMeta2));

	}

}
