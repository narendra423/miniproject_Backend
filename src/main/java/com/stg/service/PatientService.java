package com.stg.service;

import java.time.LocalDate;
import java.util.List;

import com.stg.entity.Doctor;
import com.stg.entity.Patient;

public interface PatientService {
	public abstract Patient admitPatient(Patient patient);
	public abstract Patient readPatientById(int id);
	public abstract Patient readPatientByNameAndId(String patientName,int id);
	public abstract Patient readPatientIdByNameAndAdmittedDate(String patientName,LocalDate date);
	public abstract List<Patient> readNumberOfPatientsByAdmittedDateAndHospitalId(LocalDate date,int id);
	public abstract List<Patient> readPatientsByAdmittedDate(LocalDate date);
	public abstract int getCurrentPatientIdByMobile(String mobile);
	public abstract List<Patient> readAllPatients();
	public abstract String updatePatientBloodGroupById(int id,String bloodGroup);
	public abstract List<Patient> deletePatientById(int patientId);
	
	public abstract Doctor getDoctorWithPatientId(int patientId);
	
	public abstract List<String> getAllPatientNames();
	public abstract List<Patient> readAllPatientsByNames(List<String> pnames);
	
}
