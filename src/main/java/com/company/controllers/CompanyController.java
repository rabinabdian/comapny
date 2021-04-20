package com.company.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.beans.Employee;
import com.company.bl.CompanyManager;


@RestController
@RequestMapping("CompanyManager")
public class CompanyController {

	@Autowired
	CompanyManager companyManager;
	
	@GetMapping("get")
	public ResponseEntity<List<Employee>> getAll()
	{
		List<Employee> employees = this.companyManager.getAllEmployees();		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
	}
	
}
