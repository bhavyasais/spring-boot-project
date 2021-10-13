package com.spring.springboot.wizard.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.springboot.wizard.entity.Wizard;



public interface WizardRepository extends JpaRepository<Wizard, Integer> {
	
	public List<Wizard> findAll();
	@Query("FROM Wizard ORDER BY lastName DESC")
	public List<Wizard> findAllByOrderByLastNameDesc();
	public List<Wizard> findAllByOrderByLastNameAsc();
	
}
