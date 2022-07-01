package com.stg.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Doctor;
import com.stg.entity.Patient;
import com.stg.exception.ExceptionClass;
import com.stg.repository.DoctorRepository;
import com.stg.repository.PatientRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor readDoctorById(int id) {
		Doctor doctorTemp=doctorRepository.findDoctorByDoctorId(id);
		
		if (doctorTemp!=null) {
			return doctorTemp;
		}
		else {
			throw new ExceptionClass("No Doctor Found with the Given ID");
		}
	}

	@Override
	public Doctor readDoctorByNameAndId(String name, int id) {
		Doctor temp=doctorRepository.findDoctorByDoctorId(id);
		if (temp!=null && temp.getDoctorName().equals(name)) {
			return temp;
		}
		else {
			throw new ExceptionClass("No Doctor Found with id and name");
		}
	}

	@Override
	public int readDoctorIdByDoctorNameAndSpecialization(String name, String specialization) {
		Doctor tempDoctor=doctorRepository.findDoctorByDoctorNameAndDoctorSpecialization(name, specialization);
		if (tempDoctor!=null) {
			return tempDoctor.getDoctorId();
		}
		else {
			throw new ExceptionClass("No Doctor Found with the Given name and specialization");
		}
	}

	@Override
	public String updateDoctorSpecializationByDoctorId(String specialization, int id) {
		Doctor temp=doctorRepository.findDoctorByDoctorId(id);
		if (temp!=null) {
			temp.setDoctorSpecialization(specialization);
			doctorRepository.save(temp);
			return "Recorded Updated";
		}
		else {
			throw new ExceptionClass("No Doctor Found with the Given ID");
		}
	}

	@Override
	public String updateDoctorAgeByDoctorId(int age, int id) {
		Doctor temDoctor=doctorRepository.findDoctorByDoctorId(id);
		if (temDoctor!=null) {
			temDoctor.setDoctorAge(age);
			doctorRepository.save(temDoctor);
			return "Age Updated";
		}
		else {
			throw new ExceptionClass("No Doctor Found With the given ID");
		}
	}

	@Override
	public List<Doctor> deleteDoctorById(int id) {
		Doctor temp=doctorRepository.findDoctorByDoctorId(id);
		if (temp!=null) {
			doctorRepository.delete(temp);
			return doctorRepository.findAll();
		}
		else {
			throw new ExceptionClass("No Doctor Found with the given ID");
		}
	}

	@Override
	public Doctor assignPatientstoDoctor(List<Patient> patients, int doctorId) {
		Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
		
		doctor.setDoctorPatients(patients);
		
		return doctorRepository.save(doctor);
		
	}

	@Override
	public Doctor assignPatientstoDoctorWithId(int patientId, int doctorId) {
		Doctor doctor=doctorRepository.findDoctorByDoctorId(doctorId);
		
		Patient patient= patientRepository.findByPatientId(patientId);
		
		List<Patient> list= doctor.getDoctorPatients();
		//System.out.println(list);
		list.add(patient);
		
		doctor.setDoctorPatients(list);
		//System.out.println(list);
		
		
		return doctorRepository.save(doctor);
		
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> Temp=doctorRepository.findAll();
		return Temp;
	}

	@Override
	public List<Patient> getPatientsByDoctorId(int doctorId) {
		
		Doctor doctor= doctorRepository.findDoctorByDoctorId(doctorId);
		
		return doctor.getDoctorPatients();
	}
	
	
}
