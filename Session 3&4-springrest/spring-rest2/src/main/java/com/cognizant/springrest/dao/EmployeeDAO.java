package com.cognizant.springrest.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springrest.Employee;
import com.cognizant.springrest.service.exception.EmployeeNotFoundException;

@Component
public class EmployeeDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAO.class);
	static ArrayList<Employee> EMPLOYEE_LIST;
	
	public EmployeeDAO() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
		
	}

	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		LOGGER.info("Inside updateEmployee() method");
		for(Employee emp:EMPLOYEE_LIST)
		{
			if(emp.getId()==employee.getId())
			{
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setDepartment(employee.getDepartment());
				
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return EMPLOYEE_LIST;
	}

	public void deleteEmployee(int id) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		Employee emp=null;
		for(Employee e:EMPLOYEE_LIST)
		{
			if(e.getId()==id)
			{
				emp=e;
				EMPLOYEE_LIST.remove(emp);
				break;
			}
		}
		if(emp==null)
		{
			throw new EmployeeNotFoundException();
		}
		
	}

}
