package com.java.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Employee;
import com.java.repository.EmployeeRepository;
//http://localhost:8080/<context-root>/employee/1
@Controller
public class EmployeeController {
	
	@Autowired EmployeeRepository rep;
	
	@RequestMapping(path="/employees", method=RequestMethod.GET)
	public ModelAndView getEmployees(ModelAndView mv){
		mv.setViewName("display");
		mv.addObject("employees", rep.getEmployees());
		return mv;
	}
	//Bydefault :get
//	@RequestMapping("/employee/{id}")
	@GetMapping("/employee/{id}")
	public ModelAndView getEmployeeById(@PathVariable("id") int empId, ModelAndView mv){
		mv.setViewName("display");
		mv.addObject("employees", rep.getEmployeeById(empId));
		return mv;
	}
	
	//update, remove, insert
	@PostMapping("/addEmployee.htm")
	public void addEmployee(@RequestParam String name) {
		
	}
	
	@PostMapping("/addEmployee.htm")
	public void addEmployee(HttpServletRequest request) {
		
	}
	
	@PostMapping("/addEmployee.htm")
	public void addEmployee(@ModelAttribute Employee employee) {
		
	}
	
	
}
