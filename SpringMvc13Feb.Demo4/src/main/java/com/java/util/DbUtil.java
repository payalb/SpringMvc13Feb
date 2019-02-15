package com.java.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DbUtil {

	@Value("${url}")
	String url;
	@Value("${username}")
	String username;
	@Value("${password}")
	String password;
	@Value("${driverClassName}")
	String driverClassName;
	
}
