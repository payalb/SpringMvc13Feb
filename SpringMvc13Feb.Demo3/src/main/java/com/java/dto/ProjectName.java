package com.java.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.java.util.ProjectNameValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ProjectNameValidator.class)
public @interface ProjectName {

	String message() default "Project name is invalid";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	boolean isActive() default true;
	
}
