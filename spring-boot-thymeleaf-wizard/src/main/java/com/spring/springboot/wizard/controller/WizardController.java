package com.spring.springboot.wizard.controller;


import java.util.List;

import javax.validation.Valid;

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

import com.spring.springboot.wizard.entity.Wizard;
import com.spring.springboot.wizard.service.WizardService;

@Controller
@RequestMapping("/wizards")
public class WizardController {

	private WizardService wizardService;
	
	public WizardController(WizardService theWizardService) {
		wizardService = theWizardService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	
	@GetMapping("/list")
	
	public String listWizards(Model theModel) {
		
		List<Wizard> wizards = wizardService.findAll();
		theModel.addAttribute("wizards", wizards);
		return "wizards/list-wizards";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Wizard theWizard = new Wizard();
		theModel.addAttribute("wizard", theWizard);
		return "wizards/wizard-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("wizardId") int theId,Model theModel) {
	
		Wizard theWizard = wizardService.findById(theId);
		theModel.addAttribute("wizard", theWizard);
		return "wizards/wizard-form";			
	}
	
	
	@PostMapping("/save")
	public String saveWizard(@Valid @ModelAttribute("wizard") Wizard theWizard,BindingResult theBindingResult) {
		System.out.println(theBindingResult);
		if (theBindingResult.hasErrors()) {
			return "wizards/wizard-form";
		}
		else {
		wizardService.save(theWizard);
		return "redirect:/wizards/list";
		}
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("wizardId") int theId) {
		
		wizardService.deleteById(theId);
		return "redirect:/wizards/list";
		
	}
	

}

















