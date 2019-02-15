package com.java.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:database.properties")
@ImportResource("/WEB-INF/Servlet1-servlet.xml")
public class DbUtil {
	
	@Autowired Environment env;

	@Value("${url}")
	String url;
	String username;
	String password;
	String driverClassName;
	
	public String getData() {
		System.out.println(url);
		return env.getProperty("url");
	}
	
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}*/
}
