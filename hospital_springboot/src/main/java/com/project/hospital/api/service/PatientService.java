package com.project.hospital.api.service;

import java.util.List;

import com.project.hospital.api.entity.Patient;




public interface PatientService {

	public List<Patient> findAll();
	
	public Patient findById(int theId);
	
	public void save(Patient thePatient);
	
	public void deleteById(int theId);

	public List<Patient> searchBy(String theName);
	
}