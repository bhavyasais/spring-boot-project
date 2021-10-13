package com.project.hospital.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital.api.entity.Medicine;
import com.project.hospital.api.entity.Patient;





public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	
	public List<Medicine> findAll();
	
	public List<Medicine> findByPatientId(int patientId);
	
	//public List<Medicine> findByPatientId(Patient patient);
	
	Optional<Medicine> findByIdAndPatientId(int id, int patientId);
	
	public List<Medicine> findByNameContainsAllIgnoreCase(String name);

	
}
