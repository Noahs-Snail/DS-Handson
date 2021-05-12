package com.cognizant.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest.Department;
import com.cognizant.springrest.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments(){
		
		return departmentService.getAllDepartments();
	}

}
