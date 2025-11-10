package com.empmanage.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmpID;
	@Column
	@NotBlank(message = "Employee name cannot be blank.")
	@Size(min = 2, max = 20, message = "Name must contain between 2 and 20 characters.")
	private String Name;
	@Column
	@NotBlank(message = "Department cannot be blank.")
	private String Department;
	@Column
	@NotNull(message = "Salary cannot be null.")
	@PositiveOrZero(message = "Salary must be zero or positive.")
	private Integer Salary;

	public Employee() 
	{
		
	}
	
	public Employee(int empID, String name, String department, Integer salary) 
	{
		super();
		EmpID = empID;
		Name = name;
		Department = department;
		Salary = salary;
	}

	public int getEmpID() 
	{
		return EmpID;
	}
	
	public void setEmpID(int empID) 
	{
		EmpID = empID;
	}
	
	public String getName() 
	{
		return Name;
	}
	
	public void setName(String name) 
	{
		Name = name;
	}
	
	public String getDepartment() 
	{
		return Department;
	}
	
	public void setDepartment(String department) 
	{
		Department = department;
	}
	
	public Integer getSalary() 
	{
		return Salary;
	}
	
	public void setSalary(Integer salary) 
	{
		Salary = salary;
	}
	
	@Override
	public String toString() 
	{
		return "Employee [EmpID=" + EmpID + ", Name=" + Name + ", Department=" + Department + ", Salary=" + Salary
				+ "]";
	}
}
