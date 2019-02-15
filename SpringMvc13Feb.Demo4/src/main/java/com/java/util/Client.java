package com.java.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Client implements EnvironmentAware{
	public Environment env; 
	@Autowired DbUtil util;
	@Autowired MyBean bean;
	@GetMapping("/prop.do")
	@ResponseBody
	public String getValues(Model model) {
		return util.getUrl()+ ","+ bean.url+ ","+ env.getProperty("url");
		
	}
	@Override
	public void setEnvironment(Environment environment) {
		env=environment;
		
	}
}
