package com.empmanage.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empmanage.demo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> 
{
	@Query("SELECT e FROM Employee e WHERE e.Name LIKE %:keyword% OR e.Department LIKE %:keyword%")
    List<Employee> searchEmployees(@Param("keyword") String keyword);
}
