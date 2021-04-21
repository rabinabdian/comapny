package com.company.controllers;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.beans.Employee;
import com.company.bl.CompanyManager;
import com.company.repo.EmployeeRepository;

@RestController
@RequestMapping("CompanyManager")
public class CompanyController {

	@Autowired
	CompanyManager companyManager;
	
	@Autowired
	EmployeeRepository repo;
	
	
	@GetMapping("get")
	public ResponseEntity<List<Employee>> getAll()
	{
		List<Employee> employees = this.companyManager.getAllEmployees();		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
	}
	
	@PostMapping("addEmployee")
	/**
	 * This add employee to DB
	 * 
	 * @param employee
	 * @return
	 */
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		try
		{
			this.companyManager.addEmployee(employee);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Exception>(e,HttpStatus.FORBIDDEN);
		}
		
	}
	
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable("id") Long id)
	{
		System.out.println("Searching employee with id: "+ id);
		return this.repo.getEmployeeById(id);
	}
	
}
