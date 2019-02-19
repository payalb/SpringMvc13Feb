package com.java.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.LoginDetails;

@Controller
public class LoginController {

	
	@GetMapping("/login.do")
	public String getLoginPage() {
		return "login";
	}
	

	@PostMapping("/validate.do")
	public String validateLoginDetails(@Valid @ModelAttribute LoginDetails details, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("message", result.getAllErrors().stream().map(x-> x.getDefaultMessage()).collect(Collectors.toList()));
			return "login";
		}
		/**
		 * TODO
		 */
		return "welcome";
	}
}
