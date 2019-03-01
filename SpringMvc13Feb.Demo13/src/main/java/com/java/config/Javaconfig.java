package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.java")
@EnableWebMvc
/*@ImportResource("classpath:spring-core.xml")*/
public class Javaconfig {


	@Bean
	public ViewResolver resolver() {
		return new InternalResourceViewResolver("/", ".jsp");
	}
	

	@Bean
	public static PropertySourcesPlaceholderConfigurer configurer() {
		PropertySourcesPlaceholderConfigurer cfg= new PropertySourcesPlaceholderConfigurer();
		/*cfg.setLocation(new ClassPathResource("database.properties"));*/
		return cfg;
	}
	

}
