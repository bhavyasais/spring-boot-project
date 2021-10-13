package com.project.hospital.api.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.hospital.api.entity.Medicine;
import com.project.hospital.api.entity.Patient;
import com.project.hospital.api.service.MedicineService;
import com.project.hospital.api.service.PatientService;


@Controller
@RequestMapping("/patients")
public class PatientController {
	   private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService thePatientService) {
		patientService = thePatientService;
	}
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping("/list")
	
	public String listPatients(Model theModel) {
		
		List<Patient> patients = patientService.findAll();
		theModel.addAttribute("patients", patients);
		return "patients/list-patients";
	}
	
	
@GetMapping("/medicineList")
	
	public String listMedicines(Model theModel,@RequestParam("patientId") int theId) {
	
	List<Patient> patients = patientService.findAll();
	List<Medicine> medicines = medicineService.findAll();
	theModel.addAttribute("patients", patients);
	theModel.addAttribute("medicines", medicines);
	return "patients/list-medicines";
}
	
@GetMapping("/medList")

public String listMed(Model theModel,@RequestParam("patientId") int theId) {
		//List<Medicine> medicines = medicineService.findAll();
	List<Medicine> medicines = medicineService.findByPatientId(theId);
	//System.out.println(medicines);
	//logger.info(medicines.toString());
	theModel.addAttribute("medicines", medicines);
	return "patients/list-med";
}

@GetMapping("/search")
public String search(@RequestParam("patientName") String theName,Model theModel) {
	
	
	List<Patient> patients = patientService.searchBy(theName);
	
	
	theModel.addAttribute("patients", patients);
	
	
	return "patients/list-patients";
	
}
	
}
















