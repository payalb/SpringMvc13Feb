package com.java.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class Doctor {

	int id;
	String name, street, city, specialization;
	int age, yearsOfExp, pincode;
	//Calendar for a doctor sun: 11 am -> 2 pm
	//mon: 2-> 4 pm, 6-> 9 pm
	
	@Component
	public static class DoctorRowMapper implements RowMapper<Doctor>{

		@Override
		public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Doctor doctor= new Doctor();
			doctor.setId(rs.getInt("id"));
			/**@TODO
			 */
			return doctor;
		}
		 
	 }
}
