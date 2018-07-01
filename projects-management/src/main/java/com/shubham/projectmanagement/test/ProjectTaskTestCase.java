package com.shubham.projectmanagement.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.projectmanagement.configuration.HibernateConfig;
import com.shubham.projectmanagement.dao.ProjectDao;
import com.shubham.projectmanagement.dao.TaskDao;
import com.shubham.projectmanagement.dto.Project;
import com.shubham.projectmanagement.dto.Task;


public class ProjectTaskTestCase {
	
	private static ProjectDao projectDao; 
	private static TaskDao taskDao;
	
	private static AnnotationConfigApplicationContext context;
	
	private Project project;
	private Task task;
	private Task task2;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(HibernateConfig.class);

		projectDao = context.getBean(ProjectDao.class);
		taskDao = context.getBean(TaskDao.class);
	}
	
	@Test
	// Add
	public void CrudProjectTask() {
	
		// for add/Create
		project = new Project();
		task = new Task(); 
		
		//task.setTasks("Task1");
		//task.setStatus(true);
		
		project.setProjectName("BuilderBob");
		project.setTeamLeadId(3);
		project.setStatus(true);
		assertEquals("Failed to add project", true, projectDao.add(project));
		//project.setDevelopersId();
		
		//project.setTasks(task);
		task.setTasks("Task1");
		task.setStatus(true);
		task.setProject(project);
		
		task2 = new Task();
		task2.setTasks("Task2");
		task2.setStatus(true);
		task2.setProject(project);
		
		assertEquals("Failed to add task", true, taskDao.add(task));
		assertEquals("Failed to add task", true, taskDao.add(task2));
		
		//for read
		task=taskDao.get(2);
		project=projectDao.get(4);
		
		assertEquals("Failed to read project", "Task1",task.getTasks() );
		assertEquals("Failed to read task", "BuilderBob",project.getProjectName() );
		
		//for update
		task=taskDao.get(2);
		task.setTasks("task_update");
		project=projectDao.get(1);
		project.setProjectName("Builder_Bob");
		
		assertEquals("Failed to read project", true,taskDao.update(task) );
		assertEquals("Failed to read task", true,projectDao.update(project) );
		
		//for soft Delete
		task=taskDao.get(2);
		project=projectDao.get(1);
		
		assertEquals("Failed to read project", true,taskDao.softDelete(task) );
		assertEquals("Failed to read task", true,projectDao.hardDelete(project) );
		
		//for hard Delete
		task=taskDao.get(2);
		project=projectDao.get(1);
				
		assertEquals("Failed to read project", true,taskDao.hardDelete(task) );
		assertEquals("Failed to read task", true,projectDao.hardDelete(project));
				
		
	}
}
