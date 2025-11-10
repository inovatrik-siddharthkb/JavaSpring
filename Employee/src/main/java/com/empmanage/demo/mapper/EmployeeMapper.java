package com.empmanage.demo.mapper;

import org.springframework.stereotype.Component;

import com.empmanage.demo.dto.EmployeeDTO;
import com.empmanage.demo.entity.Employee;

@Component
public class EmployeeMapper 
{
	public EmployeeDTO toDto(Employee employee)
	{
		if(employee == null)
		{
			return null;
		}
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpID(employee.getEmpID());
		dto.setName(employee.getName());
		dto.setDepartment(employee.getDepartment());
		dto.setSalary(employee.getSalary());
		
		return dto;
	}
	
	public Employee toEntity(EmployeeDTO dto)
	{
		if(dto == null)
		{
			return null;
		}
		
		Employee employee = new Employee();
		employee.setName(dto.getName());
		employee.setDepartment(dto.getDepartment());
		employee.setSalary(dto.getSalary());
		
		return employee;
	}
	
	public void updateEntityFtomDto(EmployeeDTO dto, Employee entity)
	{
		if(dto == null || entity == null)
		{
			return;
		}
		
		if(dto.getName() != null)
		{
			entity.setName(dto.getName());
		}
		
		if(dto.getDepartment() != null)
		{
			entity.setDepartment(dto.getDepartment());
		}
		
		if(dto.getSalary() != null)
		{
			entity.setSalary(dto.getSalary());
		}
	}
}
