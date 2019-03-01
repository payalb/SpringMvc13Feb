package com.java.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.java.dto.Account;
import com.java.dto.TransferForm;

@Configuration
@PropertySource(value="classpath:database.properties")
@EnableTransactionManagement(proxyTargetClass=false)
public class DBConfig {
	@Autowired Environment env;
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
	public SessionFactory sf() throws IOException {
		LocalSessionFactoryBean bean= new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setAnnotatedClasses(Account.class, TransferForm.class);
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "create");
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, "true");
		hibernateProperties.setProperty(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
		bean.setHibernateProperties(hibernateProperties);
		bean.afterPropertiesSet();
		return bean.getObject();
	}
	@Bean
	public HibernateTemplate hibernateTemplate() throws IOException {
		return new HibernateTemplate(sf());
	}
	
	@Bean("trannsactionManager")
	public HibernateTransactionManager tm() throws IOException {
		return new HibernateTransactionManager(sf());
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean("tm")
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager tx= new DataSourceTransactionManager(dataSource());
		return tx;
	}
}
