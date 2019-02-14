package com.java.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBean implements InitializingBean, BeanNameAware, BeanFactoryAware, DisposableBean{
	int x;

	MyBean(){
		System.out.println(1);
	}

	public void setX(int x) {
		System.out.println(2);
		this.x= x;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(4);
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println(3);
	}

	public void init1() {
		System.out.println(5);
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println(name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory.toString());
	}
	
	@PreDestroy
	public void dest() {
		System.out.println(6);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(7);
		
	}
	
	public void dest1() throws Exception {
		System.out.println(8);
		
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= new ClassPathXmlApplicationContext("/WEB-INF/Servlet1-servlet.xml");
		ctx.registerShutdownHook();
	}
}
