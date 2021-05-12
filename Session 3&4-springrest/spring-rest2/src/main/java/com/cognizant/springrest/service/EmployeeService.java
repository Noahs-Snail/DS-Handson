package com.cognizant.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springrest.Employee;
import com.cognizant.springrest.dao.EmployeeDAO;
import com.cognizant.springrest.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	

	@Autowired
	private EmployeeDAO employeeDao;

	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(id);
		
	}

}
