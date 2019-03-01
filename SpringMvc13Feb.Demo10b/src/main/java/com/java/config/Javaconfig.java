package com.java.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("com.java")
@EnableWebMvc
@Configuration
@PropertySource(value="classpath:database.properties")
@EnableTransactionManagement(proxyTargetClass=false)
public class Javaconfig implements WebMvcConfigurer{

	@Autowired Environment env;
	@Bean
	public ViewResolver resolver() {
		return new InternalResourceViewResolver("/", ".jsp");
	}
	
	@Override
	public  void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login.htm").setViewName("login");
	}
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource ds= new BasicDataSource();
		ds.setUrl(env.getProperty("url"));
		System.out.println(env.getProperty("url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setDriverClassName(env.getProperty("driverClassName"));
		ds.setDefaultAutoCommit(false);
		return ds;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer configurer() {
		PropertySourcesPlaceholderConfigurer cfg= new PropertySourcesPlaceholderConfigurer();
		/*cfg.setLocation(new ClassPathResource("database.properties"));*/
		return cfg;
	}
	
	@Bean
	public JdbcTemplate template() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean("tm")
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager tx= new DataSourceTransactionManager(dataSource());
		return tx;
	}
}
