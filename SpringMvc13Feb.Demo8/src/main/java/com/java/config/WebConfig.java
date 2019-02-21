package com.java.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	//	AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext(SpringCoreConfig.class);
		Dynamic servlet=servletContext.addServlet("ds", DispatcherServlet.class);
		servlet.addMapping("*.do");
		servlet.setInitParameter("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
		servlet.setInitParameter("contextConfigLocation", "com.java.config.SpringMvcConfig com.java.config.SpringDbConfig");
	}

}
