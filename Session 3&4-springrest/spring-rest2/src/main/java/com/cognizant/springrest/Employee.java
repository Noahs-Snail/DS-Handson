package com.cognizant.springrest;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;

public class Employee {
	
	@NotNull
	@NumberFormat
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min=1,max = 30)
	private String name;
	
	@NotNull
	@Min(value = 0)
    private double salary;
	
	@NotNull
	private Department department;
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary +  ", department=" + department +  "]";
	}

}
