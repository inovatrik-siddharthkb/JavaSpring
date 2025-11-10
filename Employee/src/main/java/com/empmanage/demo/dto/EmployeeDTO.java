package com.empmanage.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class EmployeeDTO 
{
	private int empID;
	
	@NotBlank(message = "Employee name cannot be blank.")
	@Size(min = 2, max = 20, message = "Name must contain between 2 and 20 characters.")
	private String name;
	
	@NotBlank(message = "Department cannot be blank.")
	private String department;

	@NotNull(message = "Salary cannot be null.")
	@PositiveOrZero(message = "Salary must be zero or positive.")
	private Integer salary;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
