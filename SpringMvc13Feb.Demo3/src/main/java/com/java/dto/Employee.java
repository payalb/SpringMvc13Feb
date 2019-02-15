package com.java.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Employee {

	public int id;
	@NotNull
	@Size(min=3, max=30, message="{Size.employee.name}")
	String name;
	@NotEmpty
	@ProjectName(isActive=false)
	@Size(min=3, max=30)
	String projectName;
	@Min(100000)
	float salary;
	@Future
	LocalDate doj= LocalDate.now();//yyyy-mm-dd
}
