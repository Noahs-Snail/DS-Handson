package com.cognizant.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springrest.Department;
import com.cognizant.springrest.dao.DepartmentDAO;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;

	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentDAO.getAllDepartments();
	}

}
