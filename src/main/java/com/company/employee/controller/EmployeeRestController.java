package com.company.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.employee.entity.Employee;
import com.company.employee.repository.EmployeeJpaRepository;


@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	@Autowired
	@Qualifier("employeeJpaRepository")
	private EmployeeJpaRepository employeeJpa;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> consultar() {
		return employeeJpa.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/lastName/{lastName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> buscarPorLastName(@PathVariable String lastName) {
		return employeeJpa.getByLastName(lastName);
    }
}
