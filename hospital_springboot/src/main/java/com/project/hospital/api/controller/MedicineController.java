package com.project.hospital.api.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.project.hospital.api.entity.Medicine;
import com.project.hospital.api.entity.Patient;
import com.project.hospital.api.service.MedicineService;
import com.project.hospital.api.service.PatientService;


@Controller
@RequestMapping("/medicines")
public class MedicineController {

	private MedicineService medicineService;
	
	@Autowired
	public MedicineController(MedicineService theMedicineService) {
		medicineService = theMedicineService;
	}
	
	@Autowired
	private PatientService patientService;
	
	
	
	@GetMapping("/list")
	
	public String listMedicines(Model theModel) {
		
		List<Medicine> medicines = medicineService.findAll();
		theModel.addAttribute("medicines", medicines);
		return "medicines/list-medicines";
	}
	

	@GetMapping("/search")
	public String search(@RequestParam("medicineName") String theName,Model theModel) {
		
		
		List<Medicine> medicines = medicineService.searchBy(theName);
		
		
		theModel.addAttribute("medicines", medicines);
		
		
		return "patients/list-med";
		
	}
	

}















