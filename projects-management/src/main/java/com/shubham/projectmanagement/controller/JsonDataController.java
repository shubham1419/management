package com.shubham.projectmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shubham.projectmanagement.dao.DeveloperDao;
import com.shubham.projectmanagement.dao.ProjectDao;
import com.shubham.projectmanagement.dto.Developer;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private DeveloperDao developerDao;
	
	@Autowired
	private ProjectDao projectDao;

	@RequestMapping("/all/developer")
	@ResponseBody
	public List<Developer> allDeveloper() {
		return developerDao.list();
	}

	@RequestMapping("/{id}/developer")
	@ResponseBody
	public Developer getDeveloperById(@PathVariable int id) {
		return developerDao.get(id);

	}
}
