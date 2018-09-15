package com.company.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.employee.entity.Employee;
import com.company.employee.entity.User;
import com.company.employee.repository.EmployeeJpaRepository;
import com.company.employee.repository.UserJpaRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	@Qualifier("userJpaRepository")
	private UserJpaRepository userJpa;

	@GetMapping("/login")
	public String goLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

    @PostMapping("/login")
	public String login(User user, Model model) {
    		List<User> userList = userJpa.validateUser(user.getName(), user.getPassword());
		if(!userList.isEmpty()) {
			/*EmployeeController employeeController = new EmployeeController();
			employeeController.getAll(model);*/
			model.addAttribute("tipoUsuario",userList.get(0).getType());
			
			return "redirect:/employee/user/"+userList.get(0).getType();			
		}else {	
	    		model.addAttribute("mensaje", "Wrong password. Try again or click Forgot password to reset it.");
			return "login";	
		}
	}
}
