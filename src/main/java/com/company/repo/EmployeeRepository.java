package com.company.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	List<Employee> findEmployeeByName(String name);

	Employee getEmployeeById(long id);

	List<Employee> getEmployeeByName(String name);

	//Employee findOne(long empId);
}
