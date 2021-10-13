package com.project.hospital.api.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital.api.entity.Patient;





public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	public List<Patient> findAll();
	
	
	public List<Patient> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
