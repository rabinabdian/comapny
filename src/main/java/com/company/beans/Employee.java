package com.company.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Employee {
	
	
	@OneToMany(mappedBy="employee")

	private long id;
	private String name;
	private double salary;
	@ApiModelProperty(hidden = true)
	private List<Job> jobs= new ArrayList<>();
	
	 public Employee() {
		// TODO Auto-generated constructor stub
	}
	 public Employee(long id,String name,double salary) {
		// TODO Auto-generated constructor stub
		 this.id=id;
		 this.name=name;
		 this.salary=salary;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", jobs=" + jobs + "]";
	}

}
