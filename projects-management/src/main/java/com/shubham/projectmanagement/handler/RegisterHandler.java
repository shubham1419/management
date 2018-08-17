package com.shubham.projectmanagement.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.shubham.projectmanagement.dao.EmployeeDao;
import com.shubham.projectmanagement.dao.EmployeeMetaDao;
import com.shubham.projectmanagement.dto.Employee;
import com.shubham.projectmanagement.dto.EmployeeMeta;
import com.shubham.projectmanagement.model.RegisterModel;

@Component
public class RegisterHandler {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	EmployeeMetaDao employeeMetaDao;

	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	public void addEmployee(RegisterModel registerModel, Employee employee)
	{
		registerModel.setEmployee(employee);
	}
	
	public void addEmployeeMeta(RegisterModel registerModel, EmployeeMeta employeeMeta)
	{
		registerModel.setEmployeeMeta(employeeMeta);
	}
	 
	public String saveAll(RegisterModel registerModel)
	{
		String value="success";
		
		Employee employee = registerModel.getEmployee();
		EmployeeMeta employeeMeta = registerModel.getEmployeeMeta();
		
		/*encoding the password*/
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		
		employeeDao.add(employee);
		employeeMetaDao.add(employeeMeta);
		
		return value;
		
	}
}
