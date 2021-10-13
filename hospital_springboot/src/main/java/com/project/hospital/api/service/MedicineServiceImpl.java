package com.project.hospital.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hospital.api.dao.MedicineRepository;
import com.project.hospital.api.entity.Medicine;
import com.project.hospital.api.entity.Patient;

@Service
public class MedicineServiceImpl implements MedicineService {

	private MedicineRepository medicineRepository;
	
	@Autowired
	public MedicineServiceImpl(MedicineRepository theMedicineRepository) {
		medicineRepository = theMedicineRepository;
	}
	
	@Override
	public List<Medicine> findAll() {
		return medicineRepository.findAll();
	}

	@Override
	public Medicine findById(int theId) {
		Optional<Medicine> result = medicineRepository.findById(theId);
		
		Medicine theMedicine = null;
			theMedicine = result.get();
		return theMedicine;
	}
	 
	@Override
	public void save(Medicine theMedicine) {
		medicineRepository.save(theMedicine);
	}

	@Override
	public void deleteById(int theId) {
		medicineRepository.deleteById(theId);
	}

	@Override
	public List<Medicine> findByPatientId(int theId) {
		return medicineRepository.findByPatientId(theId);
	}

	@Override
	public Optional<Medicine> findByIdAndPatientId(int id, int patientId) {
		return medicineRepository.findByIdAndPatientId(id,patientId);
	}

	@Override
	public List<Medicine> searchBy(String theName) {
		
		List<Medicine> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = medicineRepository.findByNameContainsAllIgnoreCase(theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}

	
}



