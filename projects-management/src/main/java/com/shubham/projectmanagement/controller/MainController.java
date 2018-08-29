package com.shubham.projectmanagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.projectmanagement.dao.DeveloperDao;

@Controller
public class MainController {

	@Autowired
	private DeveloperDao developerDao;
	
	
	@RequestMapping(value = { "/", "home", "index", "dashboard" })
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userCLickDashboard", true);
		mv.addObject("title", "Dashboard");	
		return mv;
 
	}

	@RequestMapping("/login")
	public ModelAndView dashboard(@RequestParam(name="error", required=false) String error, @RequestParam(name="logout", required=false) String logout) {
		ModelAndView mv = new ModelAndView("index");
		if(error!=null)
		{
			mv.addObject("Message", "Please use valid credentials");
			mv.addObject("classs", "danger");
		}
		if(logout!=null)
		{
			mv.addObject("Message", "Your Have Successfully Logout");
			mv.addObject("classs", "success");
		}
		mv.addObject("title", "Login");
		mv.addObject("userClickIndex", true);
		return mv;
	}
	 
	@RequestMapping("/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		//fetch authentication object
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
		if(authentication!=null)
		{
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:login?logout";
 
	}
	
	@RequestMapping("access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Access Denied");
		mv.addObject("errorTitle", "Access Denied");
		mv.addObject("errorDescription", "You are not authorized to accesss this page..");
		return mv;
	}

	/** for only testing purpose **/
	@RequestMapping("testing")
	public ModelAndView testing() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userCLickTesting", true);
		mv.addObject("title", "Testing");
		/* passing list of developer */
		mv.addObject("developer", developerDao.list());
		return mv;
	}

}
