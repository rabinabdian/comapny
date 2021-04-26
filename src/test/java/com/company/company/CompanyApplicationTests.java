package com.company.company;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.company.beans.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyApplicationTests {

	 private static final String url = "http://localhost:8080";
	    private final RestTemplate restTemplate = new RestTemplate();

	    @Test
	    public void test1() { //test (add random employees)
	        for (int i = 10000; i < 10001; i++) {
	            Long id = restTemplate.postForObject(url + "/CompanyManager/addEmployee", new HttpEntity<>(new Employee((int)Math.random() * 50000,"emp_" + (int)Math.random() * 50000, (int)Math.random() * 50000)), Long.class);
	            System.out.println(id);
	        }
	    }

	    
	    @Test
	    public void test2() { //test (get all employees)
	        List<Employee> list = restTemplate.getForObject(url + "/CompanyManager/get", List.class);
	        System.out.println(list);
	    }
	    
	    @Test
	    public void test3() { //test (get employee by ID)
	        long id = 1; //existing id
	        Employee employee = restTemplate.getForObject(url + "/CompanyManager/getEmployee/" + id, Employee.class);
	        System.out.println(employee);
	    }
	    
	    @Test
	    public void test4() { //test (get employees by name)
	        String name = "e1"; //existing name
	        List<Employee> list = restTemplate.getForObject(url + "/CompanyManager/getEmployee?name=" + name, List.class);
	        System.out.println(list);
	    }


	    
}
