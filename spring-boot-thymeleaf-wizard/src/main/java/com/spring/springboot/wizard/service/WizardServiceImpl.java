package com.spring.springboot.wizard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.springboot.wizard.dao.WizardRepository;
import com.spring.springboot.wizard.entity.Wizard;

@Service
public class WizardServiceImpl implements WizardService {

	private WizardRepository wizardRepository;
	
	@Autowired
	public WizardServiceImpl(WizardRepository theWizardRepository) {
		wizardRepository = theWizardRepository;
	}
	
	@Override
	public List<Wizard> findAll() {
		return wizardRepository.findAll();
	}

	@Override
	public Wizard findById(int theId) {
		Optional<Wizard> result = wizardRepository.findById(theId);
		
		Wizard theWizard = null;
			theWizard = result.get();
		return theWizard;
	}
	 
	@Override
	public void save(Wizard theWizard) {
		wizardRepository.save(theWizard);
	}

	@Override
	public void deleteById(int theId) {
		wizardRepository.deleteById(theId);
	}


	@Override
	public List<Wizard> findAllByOrderByLastNameDesc() {
		
		return wizardRepository.findAllByOrderByLastNameDesc();
	}

	@Override
	public List<Wizard> findAllByOrderByLastNameAsc() {
		return wizardRepository.findAllByOrderByLastNameAsc();
	}



	

	
}





