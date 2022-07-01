package com.stg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.FilterJoinTable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	private String doctorName;
	private String doctorGender;
	private int doctorAge;
	private String doctorMobileNumber;
	private String doctorSpecialization;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "departmentFK", referencedColumnName = "deptId", nullable = false)
	@JsonBackReference
	private Department department;

	// @JsonManagedReference
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "doctor_patient", joinColumns = {@JoinColumn(name =
	 * "doctorId", referencedColumnName = "doctorId", nullable = false, updatable =
	 * false)}, inverseJoinColumns = {@JoinColumn(name = "patientId",
	 * referencedColumnName = "patientId", nullable = false, updatable = false)})
	 * private List<Patient> patients;
	 */
//	@JsonSerialize(contentUsing = MySerializer.class)
	@ManyToMany
	@JoinTable(name = "doctor_patients", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "patient_id"))
	List<Patient> doctorPatients;

	public Doctor() {
		super();
	}

	/*
	 * public Doctor(int doctorId, String doctorName, String doctorGender, int
	 * doctorAge, String doctorMobileNumber, String doctorSpecialization, Department
	 * department) { super(); this.doctorId = doctorId; this.doctorName =
	 * doctorName; this.doctorGender = doctorGender; this.doctorAge = doctorAge;
	 * this.doctorMobileNumber = doctorMobileNumber; this.doctorSpecialization =
	 * doctorSpecialization; this.department = department; }
	 */

	public Doctor(int doctorId, String doctorName, String doctorGender, int doctorAge, String doctorMobileNumber,
			String doctorSpecialization, Department department, List<Patient> doctorPatients) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorGender = doctorGender;
		this.doctorAge = doctorAge;
		this.doctorMobileNumber = doctorMobileNumber;
		this.doctorSpecialization = doctorSpecialization;
		this.department = department;
		this.doctorPatients = doctorPatients;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorGender() {
		return doctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}

	public int getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}

	public String getDoctorMobileNumber() {
		return doctorMobileNumber;
	}

	public void setDoctorMobileNumber(String doctorMobileNumber) {
		this.doctorMobileNumber = doctorMobileNumber;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	//@JsonManagedReference(value="docpat")
	public List<Patient> getDoctorPatients() {
		return doctorPatients;
	}

	//@JsonManagedReference(value="docpat")
	public void setDoctorPatients(List<Patient> doctorPatients) {
		this.doctorPatients = doctorPatients;
	}

}

/*
 * @JsonBackReference(value = "hosp_docs")
 * 
 * @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 * 
 * @JoinColumn(name = "hospitalFk", referencedColumnName = "hospitalId",
 * nullable = false) private Hospital hospital;
 */
