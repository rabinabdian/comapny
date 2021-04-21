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

	public void addEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> existingEmployees = this.repo.findEmployeeByName(employee.getName());
		if(existingEmployees.size()>0)
		{
			throw new Exception("Employee "+ employee.getName() +" alread exists");
		}
		this.repo.save(employee);
	}
	
	public Employee getEmployee(long id) throws Exception {
		// TODO Auto-generated method stub

		Employee existingEmployee = this.repo.getEmployeeById(id);
		if(existingEmployee !=null)
		{
			return existingEmployee;
		}
		throw new Exception("Employee "+ id +" not exists!!!!");		
	}
}
