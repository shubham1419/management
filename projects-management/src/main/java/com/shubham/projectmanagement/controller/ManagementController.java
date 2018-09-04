package com.shubham.projectmanagement.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.projectmanagement.dao.DeveloperDao;
import com.shubham.projectmanagement.dao.ProjectsDao;
import com.shubham.projectmanagement.dao.ProjectsMetaDao;
import com.shubham.projectmanagement.dto.Developer;
import com.shubham.projectmanagement.dto.Projects;
import com.shubham.projectmanagement.dto.ProjectsMeta;
import com.shubham.projectmanagement.util.FileUploadUtility;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	 private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private DeveloperDao developerDao;
	
	@Autowired
	private ProjectsDao projectsDao;
	
	@Autowired
	private ProjectsMetaDao projectsmetaDao;
	
	@RequestMapping(value="add/project", method =RequestMethod.GET)
	public ModelAndView showManageProject(@RequestParam(name="status", required= false) String status)
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickAddProject", true);
		mv.addObject("title", "Add Project");
		Projects nproject = new Projects();
		nproject.setStatus(true);
		mv.addObject("project", nproject);
		if(status!= null)
		{
			if(status.equals("success"))
			{
				mv.addObject("message","Project Added Successfully");
				mv.addObject("msgclass","success");
			}
		}
		return mv;
	}
	
	
	/*for post request*/
	@RequestMapping(value="add/project", method =RequestMethod.POST)
	public String submitProject(@ModelAttribute("project") Projects mproject, HttpServletRequest request)
	{
		logger.info(mproject.toString());
		projectsDao.add(mproject);
		return "redirect:/manage/add/project?status=success";
	}
	

	
	@RequestMapping(value="add/project/tasks", method =RequestMethod.GET)
	public ModelAndView showManageProjectTasks(@RequestParam(name="status", required= false) String status)
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickAddProjectTasks", true);
		mv.addObject("title", "Add Project Tasks");
		ProjectsMeta nprojectMeta = new ProjectsMeta();
		nprojectMeta.setStatus(true);
		mv.addObject("projectMeta", nprojectMeta);
		if(status!= null)
		{
			if(status.equals("success"))
			{
				mv.addObject("message","Project Tasks Added Successfully");
				mv.addObject("msgclass","success");
			}
		}
		return mv;
	}
	
	
	/*for post request*/
	@RequestMapping(value="add/project/tasks", method =RequestMethod.POST)
	public String submitProjectTasks(@ModelAttribute("projectMeta") ProjectsMeta mprojectMeta, HttpServletRequest request)
	{
		logger.info(mprojectMeta.toString());
		projectsmetaDao.add(mprojectMeta);
		return "redirect:/manage/add/project/tasks?status=success";
	}
	

	
	
	
	
	
	
	
	
	
	@RequestMapping(value="developer", method =RequestMethod.GET)
	public ModelAndView showManageDeveloper(@RequestParam(name="status", required= false) String status)
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickManageDeveloper", true);
		mv.addObject("title", "Manage Developer");
		Developer ndeveloper = new Developer();
		ndeveloper.setStatus(true);
		mv.addObject("developer", ndeveloper);
		if(status!= null)
		{
			if(status.equals("success"))
			{
				mv.addObject("message","DEVELOPER Added Successfully");
				mv.addObject("msgclass","success");
			}
		}
		return mv;
	}
	
	
	/*for post request*/
	@RequestMapping(value="developer", method =RequestMethod.POST)
	public String submitDeveloper(@ModelAttribute("developer") Developer mdeveloper, HttpServletRequest request)
	{
		logger.info(mdeveloper.toString());
		developerDao.add(mdeveloper);
		if(!mdeveloper.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request, mdeveloper.getFile(), mdeveloper.getImgCode());
		}
		return "redirect:/manage/developer?status=success";
	}
	
	/*Select option for developer role*/
	 @ModelAttribute("developerRole")
	   public Map<String, String> getDeveloperRoleList() {
	      Map<String, String> developerRoleList = new HashMap<String, String>();
	      developerRoleList.put("Developer", "Developer");
	      developerRoleList.put("Team_Lead", "Team Lead");
	      return developerRoleList;
	   }
}

