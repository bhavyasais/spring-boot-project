package com.project.hospital.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.hospital.api.dao.MedicineRepository;
import com.project.hospital.api.entity.Medicine;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	MedicineRepository medicineRepository;
	
	@Test
	void contextLoads() {
	}
	@Test
	public void testFindMedicinesByPatientId() {
		
		assertNotNull(medicineRepository.findAll());
		 List<Medicine> med = medicineRepository.findByPatientId(1);    
		   //assertThat(med.get(0),is("MEDICINE-A");
		 String name = med.get(0).getName();
		 assertEquals(name,"MEDICINE - A");
		// System.out.println(med);
		}
	}

