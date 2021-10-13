package com.project.hospital.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hospital.api.dao.PatientRepository;
import com.project.hospital.api.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;
	
	@Autowired
	public PatientServiceImpl(PatientRepository thePatientRepository) {
		patientRepository = thePatientRepository;
	}
	
	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findById(int theId) {
		Optional<Patient> result = patientRepository.findById(theId);
		
		Patient thePatient = null;
			thePatient = result.get();
		return thePatient;
	}
	 
	@Override
	public void save(Patient thePatient) {
		patientRepository.save(thePatient);
	}

	@Override
	public void deleteById(int theId) {
		patientRepository.deleteById(theId);
	}


	@Override
	public List<Patient> searchBy(String theName) {
		
		List<Patient> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = patientRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}

	
}




