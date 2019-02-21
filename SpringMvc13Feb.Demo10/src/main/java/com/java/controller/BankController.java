package com.java.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.TransferForm;
import com.java.service.BankingService;

@Controller
public class BankController {

	@Autowired
	BankingService service;

	@PostMapping("/transferMoney.htm")
	public String transferMoney(@Valid @ModelAttribute TransferForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMsg", result.getAllErrors());
			return "transferForm";
		}
		service.transferMoney(form);
		return "status";
	}
	
	
}
