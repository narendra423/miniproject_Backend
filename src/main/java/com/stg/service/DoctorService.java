package com.stg.service;

import java.util.List;

import com.stg.entity.Doctor;
import com.stg.entity.Patient;

public interface DoctorService {
	public abstract Doctor addDoctor(Doctor doctor);
	public abstract Doctor readDoctorById(int id);
	public abstract Doctor readDoctorByNameAndId(String name,int id);
	public abstract int readDoctorIdByDoctorNameAndSpecialization(String name,String specialization);
	
	public abstract List<Doctor> getAllDoctors();
	
	public abstract Doctor assignPatientstoDoctor(List<Patient> patients ,int doctorId);
	public abstract String updateDoctorSpecializationByDoctorId(String specialization,int id);
	public abstract String updateDoctorAgeByDoctorId(int age,int id);
	public abstract List<Doctor> deleteDoctorById(int id);
	public abstract Doctor assignPatientstoDoctorWithId(int patientId ,int doctorId);
	
	public abstract List<Patient> getPatientsByDoctorId(int doctorId);

}
