package com.project.hospital.api.entity;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    @Column(name="first_name")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    @Column(name="last_name")
    private String lastName;

    @Column(name="mobile")
    @NotNull(message = "is required")
    @Size(min=1,message="is required")
    private String mobile;
    
    @OneToMany(mappedBy="patient",cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Medicine> medicines;
    
    

	public Patient() {
		super();
	}



	public Patient(@NotNull(message = "is required") @Size(min = 1, message = "is required") String firstName,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String lastName,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String mobile,
			List<Medicine> medicines) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.medicines = medicines;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public List<Medicine> getMedicines() {
		return medicines;
	}



	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}



	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile=" + mobile + "]";
	}

   
}
