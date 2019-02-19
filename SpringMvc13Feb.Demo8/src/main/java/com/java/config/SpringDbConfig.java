package com.java.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
public class SpringDbConfig {

	@Value("${url}")
	String url;
	@Value("${username}")
	String userName;
	@Value("${password}")
	String password;
	@Value("${driverClassName}")
	String driverClassName;
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource ds= new BasicDataSource();
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		ds.setDriverClassName(driverClassName);
		return ds;
	}
	
	@Bean
	static public PropertyPlaceholderConfigurer configurer() {
		PropertyPlaceholderConfigurer configurer= new PropertyPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("database.properties"));
		return configurer;
	}
	
	@Bean
	@DependsOn("flyway")
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean(initMethod="migrate")
	public Flyway flyway() {
		Flyway flyway= new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setDataSource(dataSource());
		flyway.setLocations("classpath:/migration");
		return flyway;
	}
}
