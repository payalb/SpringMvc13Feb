package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.dto.Account;
import com.java.dto.TransferForm;
import com.java.service.BankingService;

@Controller
public class BankController {

	@Autowired
	BankingService service;

	
	@RequestMapping(path="/login", method= {RequestMethod.GET,RequestMethod.POST})
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(path="/logout", method= {RequestMethod.GET})
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "login";
	}
	/*@CrossOrigin(origins= {"http://localhost:8080"}, methods= {RequestMethod.GET})*/
	@PostMapping("/transferMoney.htm")
	public String transferMoney(@Valid @ModelAttribute TransferForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorMsg", result.getAllErrors());
			return "transferForm";
		}
		service.transferMoney(form);
		return "status";
	}
	
	@GetMapping("/addAccounts.htm")
	public String addAccounts() {
		List<Account> accounts= new ArrayList<>();
		accounts.add(new Account("Pnb", 7636373));
		accounts.add(new Account( "icici", 3323));
		accounts.add(new Account( "Pnb", 53443));
		accounts.add(new Account("icici", 2342342));
		accounts.add(new Account("axis", 45454));
		accounts.add(new Account("canara", 34534));
		//accounts.add(new Account(null, 34534));
		accounts.add(new Account( "icici", 3323));
		accounts.add(new Account( "Pnb", 53443));
		accounts.add(new Account("icici", 2342342));
		accounts.add(new Account("axis", 45454));
		accounts.add(new Account("canara", 34534));
		service.addAccounts(accounts);
		return "status";
	}
}
