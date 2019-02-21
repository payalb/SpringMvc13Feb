package com.java.service;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LoggingService {
	
	Logger logger= Logger.getLogger(LoggingService.class);
	
	@Around("execution(public * com.java.controller.*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Before method"+ pjp.getSignature());
		System.out.println("Before method"+ pjp.getSignature());
		Object o=pjp.proceed();
		logger.info("After method"+ pjp.getSignature());
		System.out.println("After method"+ pjp.getSignature());
		return o;
	}

}
