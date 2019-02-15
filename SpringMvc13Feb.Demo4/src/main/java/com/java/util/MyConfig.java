package com.java.util;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

@Configuration
@ImportResource("/WEB-INF/Servlet1-servlet.xml")
public class MyConfig {

	@Resource public Environment env;
	
	String url;
	
	{
	//	url= env.getProperty("url");
		System.out.println(env);
	}
}
