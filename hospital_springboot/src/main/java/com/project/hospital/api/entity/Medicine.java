package com.project.hospital.api.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    @Column(name="name")
    private String name;
    
    
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="patient_id")
    private Patient patient;

	public Medicine() {
		
	}
	


	public Medicine(@NotNull(message = "is required") @Size(min = 1, message = "is required") String name,
			Patient patient) {
		super();
		this.name = name;
		this.patient = patient;
	}

    

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", patient=" + patient + "]";
	}

	
    
}
