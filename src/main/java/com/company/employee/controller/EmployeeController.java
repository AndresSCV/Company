package com.company.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.employee.entity.Employee;
import com.company.employee.repository.EmployeeJpaRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeJpaRepository")
	private EmployeeJpaRepository employeeJpa;

	public String type = null;

	@GetMapping("/all")
	public String getAll(Model model) {
		model.addAttribute("employeeList", employeeJpa.findAll());
		return "employee";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{type}")
	public String goEmployee(@PathVariable String type, Model model) {
		this.setType(type);
		
		model.addAttribute("employeeList", employeeJpa.findAll());
		
		model.addAttribute("type", type);

		return "employee";
	}

	// Get employees by lastName
	@RequestMapping(method = RequestMethod.GET, value = "/lastname/{name}")
	public String getByLastName(@PathVariable String name, Model model) {

		List<Employee> employeeList = employeeJpa.getByLastName(name);

		String mensaje = null;

		if (employeeList.isEmpty()) {
			mensaje = "Employees not found";
		}

		model.addAttribute("employeeList", employeeList);
		model.addAttribute("mensaje", mensaje);

		return "employee";
	}

	// Add an employee
	//@GetMapping("/register")
	@RequestMapping(method = RequestMethod.POST, value = "/newEmployee")
	public String goRegister(Model model) {

		if (this.type.equals("ADMIN")) {

			model.addAttribute("employee", new Employee());
			return "employeeAdd";
		} else {
			model.addAttribute("mensaje", "You cant create new users");
			System.out.println("Errrorrrr usted es usuario");
			return "redirect:all";
		}
	}

	// Add an employee
	@PostMapping("/register")
	public String register(Employee employee) {
		employeeJpa.save(employee);
		return "redirect:all";
	}

	// Add an employee
	@PostMapping("/update")
	public String update(Employee employee) {
		employeeJpa.save(employee);
		return "employee";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
