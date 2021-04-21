package com.company.beans;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.company.repo.EmployeeRepository;
import com.company.repo.JobRepository;

@Component
@Scope("prototype")
public class Company {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private JobRepository jobRepo;
	
	public Long addEmployee(Employee e){
		empRepo.save(e);
		return e.getId();
	}
	
	public Employee getEmployee(long empId){
		return empRepo.getEmployeeById(empId);
	}
	
	public List<Employee> getEmployee(String name){
		return empRepo.findEmployeeByName(name);
	}
	
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	
	public List<Job> getJobs(){
		return jobRepo.findAll();
	}

	public List<Job> getJobs(Date endDate){
		return jobRepo.findJobByEndDate(endDate);
	}
	
	public List<Job> getJobs(Date start, Date end){
		return jobRepo.findJobByEndDateBetween(start, end);
	}
}
