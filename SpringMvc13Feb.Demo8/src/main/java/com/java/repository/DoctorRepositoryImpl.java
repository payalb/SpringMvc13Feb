package com.java.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDoctor(int id) {
		// TODO Auto-generated method stub
		
	}

}
