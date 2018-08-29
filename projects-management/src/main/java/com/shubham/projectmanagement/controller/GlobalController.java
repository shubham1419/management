package com.shubham.projectmanagement.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shubham.projectmanagement.dao.EmployeeDao;
import com.shubham.projectmanagement.dao.EmployeeMetaDao;
import com.shubham.projectmanagement.dto.Employee;
import com.shubham.projectmanagement.dto.EmployeeMeta;
import com.shubham.projectmanagement.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private EmployeeDao employeeDao;
	private EmployeeMetaDao employeeMetaDao;

	@Autowired
	private HttpSession session;

	private UserModel userModel = null;
	private Employee employee = null;
	private EmployeeMeta employeeMeta = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (!authentication.getPrincipal().equals("anonymousUser")) {
				// get the user from the database
				employee = employeeDao.getByEmail(authentication.getName());
				//employeeMeta = employeeMetaDao.get(2);
  
				if (employee != null) {
					// create a new model
					userModel = new UserModel();
					// set the name and the id
					userModel.setId(employee.getId());
					//userModel.setFullName(employeeMeta.getFisrtName() + " " + employeeMeta.getLastName());
					userModel.setRole(employee.getRole());

					session.setAttribute("userModel", userModel);
					return userModel;
				}
			}
		}

		return (UserModel) session.getAttribute("userModel");
}

}
