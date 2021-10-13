package com.spring.springboot.wizard.service;

import java.util.List;


import com.spring.springboot.wizard.entity.Wizard;


public interface WizardService {

	public List<Wizard> findAll();
	
	public Wizard findById(int theId);
	
	public void save(Wizard theWizard);
	
	public void deleteById(int theId);

	
	public List<Wizard> findAllByOrderByLastNameDesc();
	public List<Wizard> findAllByOrderByLastNameAsc();
	
}