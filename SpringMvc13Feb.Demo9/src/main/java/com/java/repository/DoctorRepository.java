package com.java.repository;

import java.util.List;

import com.java.dto.Doctor;

public interface DoctorRepository {
	public List<Doctor> getDoctors() ;
	public Doctor getDoctorById(int id);
	public List<Doctor> getDoctorByCity(String city);
	public List<Doctor> getDoctorBySpecialization(String specialization);
	public void addDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public void deleteDoctor(int id);

}
