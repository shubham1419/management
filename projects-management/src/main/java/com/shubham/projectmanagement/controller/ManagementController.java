package com.shubham.projectmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.projectmanagement.dao.DeveloperDao;
import com.shubham.projectmanagement.dao.ProjectsDao;
import com.shubham.projectmanagement.dao.ProjectsMetaDao;
import com.shubham.projectmanagement.dto.Developer;
import com.shubham.projectmanagement.dto.Employee;
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
	
	
	
	
	
	
	
	 // Manage dynamically added or removed employees
    private List<ProjectsMeta> manageEmployees(Projects projects) {
        // Store the employees which shouldn't be persisted
        List<ProjectsMeta> projects2remove = new ArrayList<ProjectsMeta>();
        if (projects.getProjectId() != null) {
            for (Iterator<ProjectsMeta> i = projects.getProjectId().iterator(); i.hasNext();) {
            	ProjectsMeta projectsMeta = i.next();
                // If the remove flag is true, remove the employee from the list
                if (projectsMeta.getRemove() == 1) {
                    projects2remove.add(projectsMeta);
                    i.remove();
                // Otherwise, perform the links
                } else {
                	projectsMeta.setProjects(projects);
                }
            }
        }
        return projects2remove;
    }

    // -- Creating a new employer ----------

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(@ModelAttribute Projects projects, Model model) {
        // Should init the AutoPopulatingList
        return create(projects, model, true);
    }

    private String create(Projects projects, Model model, boolean init) {
        if (init) {
            // Init the AutoPopulatingList
        	projects.setProjectId(new AutoPopulatingList<ProjectsMeta>(ProjectsMeta.class));
        }
        model.addAttribute("type", "create");
        return "tasks";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute Projects projects, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Should not re-init the AutoPopulatingList
            return create(projects, model, false);
        }
        // Call the private method
        manageEmployees(projects);
        // Persist the project
        projectsDao.add(projects);
        return "redirect:tasks/" + projects.getId();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*	
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
	
	
	/*for post request*
	@RequestMapping(value="add/project/tasks", method =RequestMethod.POST)
	public String submitProjectTasks(@ModelAttribute("projectMeta") ProjectsMeta mprojectMeta, HttpServletRequest request)
	{
		logger.info(mprojectMeta.toString());
		projectsmetaDao.add(mprojectMeta);
		return "redirect:/manage/add/project/tasks?status=success";
	}
	
*/
	
	
	
	
	
	
	
	
	
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

