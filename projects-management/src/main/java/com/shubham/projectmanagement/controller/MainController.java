package com.shubham.projectmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.projectmanagement.dao.DeveloperDao;

@Controller
public class MainController {

	@Autowired
	DeveloperDao developerDao;
	
	@RequestMapping(value={"/","home","index"})
	public ModelAndView home()
	{
	ModelAndView mv = new ModelAndView("index");
	mv.addObject("title","Login");
	mv.addObject("userClickIndex",true);
	return mv;
	}
	
	@RequestMapping("dashboard")
	public ModelAndView dashboard()
	{
	 ModelAndView mv = new ModelAndView("index");
	 mv.addObject("userCLickDashboard", true);
	 mv.addObject("title","Dashboard");
	 return mv;
	}
	
	/**for only testing purpose**/
	@RequestMapping("testing")
	public ModelAndView testing()
	{
	 ModelAndView mv = new ModelAndView("index");
	 mv.addObject("userCLickTesting", true);
	 mv.addObject("title","Testing");
	 /*passing list of developer*/
	 mv.addObject("developer", developerDao.list());
	 return mv;
	}
	
}
