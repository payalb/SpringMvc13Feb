package com.java.service;

import java.util.List;

import com.java.dto.Doctor;

public interface DoctorService {

	public List<Doctor> getDoctors() ;
	public Doctor getDoctorById(int id);
	public List<Doctor> getDoctorByCity(String city);
	public List<Doctor> getDoctorBySpecialization(String specialization);
	public void updateDoctor(Doctor doctor);
	public void deleteDoctor(int id);
	void addDoctor(Doctor doctor);

}
