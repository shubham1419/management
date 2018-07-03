package com.shubham.projectmanagement.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.projectmanagement.configuration.HibernateConfig;
import com.shubham.projectmanagement.dao.DeveloperDao;
import com.shubham.projectmanagement.dao.ProjectDao;
import com.shubham.projectmanagement.dao.TaskDao;
import com.shubham.projectmanagement.dto.Developer;
import com.shubham.projectmanagement.dto.Project;
import com.shubham.projectmanagement.dto.Task;


public class ProjectTaskDeveloperTestCase {
	
	private static ProjectDao projectDao; 
	private static TaskDao taskDao;
	private static DeveloperDao developerDao;
	
	private static AnnotationConfigApplicationContext context;
	
	private Project project;
	private Task task;
	private Task task2;
	private Developer dev1;
	private Developer dev2;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(HibernateConfig.class);

		projectDao = context.getBean(ProjectDao.class);
		taskDao = context.getBean(TaskDao.class);
		developerDao = context.getBean(DeveloperDao.class);
	}
	
	/*@Test
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
		task=taskDao.get(3);
		project=projectDao.get(4);
		
		assertEquals("Failed to read project", "Task2", task.getTasks() );
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
		assertEquals("Failed to read task", true,projectDao.softDelete(project) );
		
		//for hard Delete
		task=taskDao.get(9);
		project=projectDao.get(7);
				
		assertEquals("Failed to read project", true,taskDao.hardDelete(task) );
		assertEquals("Failed to read task", true,projectDao.hardDelete(project));
			
		
	}*/
	
	
	@Test
	public void addProjectWithDevloperAndTask()
	{
		project = new Project();
		task =new Task();
		task2 = new Task();
		dev1 = new Developer();
		dev2 = new Developer();
		
		project.setProjectName("Bountiful");
		project.setTeamLeadId(10);
		project.setStatus(true);
		
		assertEquals("Failed to add project", true, projectDao.add(project));
		
		task.setTasks("Make Dynamic");
		task.setStatus(true);
		task.setProject(project);
		
		task2.setTasks("Make Responsive");
		task2.setStatus(true);
		task2.setProject(project);
		
		assertEquals("Failed to add task1", true, taskDao.add(task));
		assertEquals("Failed to add task2", true, taskDao.add(task2));
		
		dev1.setAddress("Mathura");
		dev1.setDesignation("TeamLead");
		dev1.setEmail("email");
		dev1.setName("Mohit");
		dev1.setPassword("123456");
		dev1.setPhone("23568");
		dev1.setRole("Developer");
		dev1.setStatus(true);
		dev1.setProject(project);
		
		dev2.setAddress("Mathura");
		dev2.setDesignation("Asst.Developer");
		dev2.setEmail("email");
		dev2.setName("Ravi");
		dev2.setPassword("123456");
		dev2.setPhone("23568");
		dev2.setRole("Developer");
		dev2.setStatus(true);
		dev2.setProject(project);
		
		assertEquals("Failed to add task1", true, developerDao.add(dev1));
		assertEquals("Failed to add task2", true, developerDao.add(dev2));
		
	}
}
