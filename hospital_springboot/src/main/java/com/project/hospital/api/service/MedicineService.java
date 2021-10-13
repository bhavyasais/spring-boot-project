package com.project.hospital.api.service;

import java.util.List;
import java.util.Optional;

import com.project.hospital.api.entity.Medicine;
import com.project.hospital.api.entity.Patient;





public interface MedicineService {

	public List<Medicine> findAll();
	
	public Medicine findById(int theId);
	
	public void save(Medicine medicine);
	
	public void deleteById(int theId);

	public List<Medicine> findByPatientId(int theId);
	Optional<Medicine> findByIdAndPatientId(int id, int patientId);
	public List<Medicine> searchBy(String theName);
}