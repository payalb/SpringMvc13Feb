package com.java.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginDetails {

	@NotEmpty(message="Email id or tel no. should be entered")
	String id;
	@NotEmpty
	//@Pattern(regexp="^[A-Z]+[a-zA-Z0-9] {7,}$")
	String password;
}
