package com.java.controller;

import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Employee;
import com.java.repository.EmployeeRepository;
import com.java.util.MyDate1Editor;
//http://localhost:8080/<context-root>/employee/1
@Controller
public class EmployeeController {
	
	@Autowired EmployeeRepository rep;
	
	@RequestMapping(path="/employees.do", method=RequestMethod.GET)
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
	
/*	//update, remove, insert
	@PostMapping("/addEmployee.htm")
	public String addEmployee(@RequestParam String name) {
		return "viewname";
	}
	
	@PostMapping("/addEmployee.htm")
	public String addEmployee(HttpServletRequest request) {
		return "viewname";
	}*/
	
	/*@PostMapping("/addEmployee.do")
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		rep.addEmployee(employee);
		model.addAttribute("message", "Employee added successfully!");
		return "index";
	}*/
	
	@PostMapping("/addEmployee.do")
	public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("errorMessage", 
					result.getAllErrors().
					stream().
					map(x-> x.getDefaultMessage()).
					collect(Collectors.toList()));
			return "home";
		}
		rep.addEmployee(employee);
		model.addAttribute("message", "Employee added successfully!");
		return "index";
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.setDisallowedFields("id");
		binder.registerCustomEditor(LocalDate.class, "doj", new MyDate1Editor());
	}
	
}
