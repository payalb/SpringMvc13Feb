package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Doctor;
import com.java.repository.DoctorRepository;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{

	@Autowired DoctorRepository rep;
	@Override
	public List<Doctor> getDoctors() {
		return rep.getDoctors();
	}

	@Override
	public Doctor getDoctorById(int id) {
		return rep.getDoctorById(id);
	}

	@Override
	public List<Doctor> getDoctorByCity(String city) {
		return rep.getDoctorByCity(city);
	}

	@Override
	public List<Doctor> getDoctorBySpecialization(String specialization) {
		return rep.getDoctorBySpecialization(specialization);
	}

	@Override
	public void addDoctor(Doctor doctor) {
		rep.addDoctor(doctor);
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		rep.updateDoctor(doctor);
		
	}

	@Override
	public void deleteDoctor(int id) {
		rep.deleteDoctor(id);
		
	}

}
