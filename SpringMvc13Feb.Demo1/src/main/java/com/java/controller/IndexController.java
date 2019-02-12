package com.java.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class IndexController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mv= new ModelAndView();
		mv.addObject("message", "Hello from controller");
		mv.addObject("date", LocalDateTime.now());
		mv.setViewName("index");
		return mv;
	}

}
