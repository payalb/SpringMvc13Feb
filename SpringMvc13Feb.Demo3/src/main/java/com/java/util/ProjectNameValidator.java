package com.java.util;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.java.dto.ProjectName;

@Component
public class ProjectNameValidator implements ConstraintValidator<ProjectName, String>{
	
	boolean isActive;
	@Override
	public void initialize(ProjectName constraintAnnotation) {
		isActive =constraintAnnotation.isActive();
	}

	List<String> validValues= Arrays.asList("Java Training","Android Training", "IOS training");
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if((validValues.contains(value) && isActive)|| !isActive) {
			return true;
		}else {
		return false;
		}
	}

	
}
