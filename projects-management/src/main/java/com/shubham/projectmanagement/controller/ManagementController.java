package com.shubham.projectmanagement.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.shubham.projectmanagement.dto.Developer;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	 private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	private DeveloperDao developerDao;

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
	public String submitDeveloper(@ModelAttribute("developer") Developer mdeveloper)
	{
		logger.info(mdeveloper.toString());
		developerDao.add(mdeveloper);
		return "redirect:/manage/developer?status=success";
	}
	
	/*Select option for developer role*/
	 @ModelAttribute("developerRole")
	   public Map<String, String> getDeveloperRoleList() {
	      Map<String, String> developerRoleList = new HashMap<String, String>();
	      developerRoleList.put("Developer", "Developer");
	      developerRoleList.put("Team Lead", "Team Lead");
	      return developerRoleList;
	   }
}

