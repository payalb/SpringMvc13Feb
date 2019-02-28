package com.java.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.java.exception.InvalidStateException;

@ControllerAdvice
public class MyExceptionHanlder {
	
	@ExceptionHandler(InvalidStateException.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("errorMsg", e.getMessage());
		return "error";
	}
}
