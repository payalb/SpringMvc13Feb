package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.Employee;

//BeanNameUrlHandlerMapping: Controller, AbstractController
//RequestMappingHandlerMapping
@Controller
public class EmployeeController {
	
	@RequestMapping("/employee.do")
	//spring will inject the ModelAndView object
	public ModelAndView getEmployees(ModelAndView mv){
		//This is a fixed size list
		List<Employee> list=Arrays.asList(
							new Employee(1,"Payal","Training"),
							new Employee(2,"yash","Training"));
		//list.add(e)| remove not supported
		mv.setViewName("employeeData");
		mv.addObject("list", list);
		return mv;
	}

}
