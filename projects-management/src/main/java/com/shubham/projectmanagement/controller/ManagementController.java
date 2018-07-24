package com.shubham.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {
 
	@RequestMapping("/developer")
	public ModelAndView showManageDeveloper()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickManageDeveloper", true);
		mv.addObject("title", "Manage Developer");
		return mv;
	}
}
