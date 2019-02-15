package com.java.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dao.Product;
import com.java.exception.DatabaseException;
import com.java.repository.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired ProductRepository rep;
/*/products/3*/
	@GetMapping("/{productId}")
	public String getProductById(@PathVariable("productId") int id, Model model) throws DatabaseException {
			model.addAttribute("products", rep.getProductById(id));
			System.out.println("1");
			return "display";
	}
	
	@GetMapping
	public ModelAndView getProducts(ModelAndView mv){
		mv.addObject("products", rep.getAllProducts());
		mv.setViewName("display");
		return mv;
	}
	
	@GetMapping("/add")
	public String getProductPage(){
		return "product";
	}
	
	
	@PostMapping
	public ModelAndView insertProduct(@Valid @ModelAttribute Product product,ModelAndView mv){
		mv.addObject("products", rep.getAllProducts());
		mv.setViewName("display");
		return mv;
	}
	

	@ExceptionHandler(DatabaseException.class)
	public String exceptionHandler(Model model, Exception ex) {
		model.addAttribute("errorMsg", ex.getMessage());
		return "error";
	}
}
