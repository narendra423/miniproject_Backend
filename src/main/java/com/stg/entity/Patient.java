package com.stg.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private String patientGender;
	private int patientAge;
	private String patientBloodGroup;
	private String patientMobileNumber;
	private String patientLocation;
	private LocalDate admittedDate;

	// @JsonBackReference
	@ManyToMany(mappedBy = "doctorPatients")
	private List<Doctor> doctors;

	public Patient() {
		super();
	}

	public Patient(int patientId, String patientName, String patientGender, int patientAge, String patientBloodGroup,
			String patientMobileNumber, String patientLocation, LocalDate admittedDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientBloodGroup = patientBloodGroup;
		this.patientMobileNumber = patientMobileNumber;
		this.patientLocation = patientLocation;
		this.admittedDate = admittedDate;
	}

	public Patient(int patientId, String patientName, String patientGender, int patientAge, String patientBloodGroup,
			String patientMobileNumber, String patientLocation, LocalDate admittedDate, List<Doctor> doctors) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientBloodGroup = patientBloodGroup;
		this.patientMobileNumber = patientMobileNumber;
		this.patientLocation = patientLocation;
		this.admittedDate = admittedDate;
		this.doctors = doctors;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}

	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}

	public String getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(String patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	public String getPatientLocation() {
		return patientLocation;
	}

	public void setPatientLocation(String patientLocation) {
		this.patientLocation = patientLocation;
	}

	public LocalDate getAdmittedDate() {
		return admittedDate;
	}

	public void setAdmittedDate(LocalDate admittedDate) {
		this.admittedDate = admittedDate;
	}

	@JsonBackReference("doctorPatients")
	public List<Doctor> getDoctors() {
		return doctors;
	}

	@JsonBackReference("doctorPatients")
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}

/*
 * @JsonBackReference(value = "hosp_patients")
 * 
 * @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 * 
 * @JoinColumn(name = "hospitalFk", referencedColumnName = "hospitalId",
 * updatable = false, nullable = false) private Hospital hospital;
 */
