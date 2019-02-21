package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.Doctor;
import com.java.service.DoctorService;

@Controller
@RequestMapping("/doctors.do")
public class DoctorController {

	
	@Autowired DoctorService service;
	
	@GetMapping
	public String getDoctors(Model model) {
		model.addAttribute("doctors",service.getDoctors());
		return "display";
	}
	
	@PostMapping
	public String addDoctors(@ModelAttribute Doctor doctor) {
		service.addDoctor(doctor);
		return "display";
	}
	
}
