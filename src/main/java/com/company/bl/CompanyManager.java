package com.company.bl;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.beans.Employee;
import com.company.repo.EmployeeRepository;

@Service
public class CompanyManager {

	@Autowired
	EmployeeRepository repo;
	
	public List<Employee> getAllEmployees()
	{
		Iterable<Employee> itrbl = this.repo.findAll();
		List<Employee> employees = new ArrayList<Employee>();
	    for (Employee p : itrbl) {
	    	employees.add(p);
	    }
		return employees;
	}
	
	
}
