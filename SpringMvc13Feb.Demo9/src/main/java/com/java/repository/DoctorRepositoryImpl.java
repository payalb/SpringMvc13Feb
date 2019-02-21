package com.java.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.java.dto.Doctor;
import com.java.dto.Doctor.DoctorRowMapper;

@Repository

public class DoctorRepositoryImpl implements DoctorRepository{

	@Autowired DoctorRowMapper mapper;
	@Autowired JdbcTemplate template;
	@Override
	public List<Doctor> getDoctors() {
		return template.query("select * from doctor", mapper);
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getDoctorByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getDoctorBySpecialization(String specialization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		template.update("insert into doctor values (?,?,?,?,?,?,?,?)",new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, doctor.getId());
				ps.setString(2, doctor.getName());
				ps.setString(3, doctor.getStreet());
				ps.setString(4, doctor.getCity());
				ps.setString(5, doctor.getSpecialization());
				ps.setInt(6, doctor.getAge());
				ps.setInt(7, doctor.getYearsOfExp());
				ps.setInt(8, doctor.getPincode());
			}
		});
	}
	/*id SERIAL primary key,
	name varchar(30) not null,
	street varchar(200) not null,
		city varchar(30) not null,
		specialization varchar(50) not null,
		age integer not null,
		yearsOfExp integer not null,
		pincode integer not null)*/
	@Override
	public void updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDoctor(int id) {
		// TODO Auto-generated method stub
		
	}

}
