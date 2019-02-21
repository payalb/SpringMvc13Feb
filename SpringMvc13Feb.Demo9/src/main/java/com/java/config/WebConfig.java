package com.java.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class WebConfig extends AbstractDispatcherServletInitializer{

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();
		ctx.register(SpringMvcConfig.class, SpringDbConfig.class);
		return ctx;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.do"};
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		return null;
	}

	

}
