package com.stg.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Doctor;
import com.stg.entity.Hospital;
import com.stg.entity.Patient;
import com.stg.exception.ExceptionClass;
import com.stg.repository.DoctorRepository;
import com.stg.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	

	@Override
	public Patient admitPatient(Patient patient) {
	
		return patientRepository.save(patient);
		
	}

	@Override
	public Patient readPatientById(int id) {
		Patient patientTemp = patientRepository.findByPatientId(id);
		if (patientTemp == null) {
			throw new ExceptionClass("Patient is not available with the given Id");
		} else {
			return patientTemp;
		}
	}

	@Override
	public Patient readPatientByNameAndId(String patientName, int id) {
		Patient patientTemp=patientRepository.findByPatientId(id);
		if (patientTemp!=null && patientTemp.getPatientName().equals(patientName)) {
			return patientTemp;
		}
		else {
			throw new ExceptionClass("Patient is not available with the given name and id");
		}
	}

	@Override
	public Patient readPatientIdByNameAndAdmittedDate(String patientName, LocalDate date) {
		Patient Temp=patientRepository.findByPatientAdmittedDate(date);
		if (Temp!=null && Temp.getPatientName().equals(patientName)) {
			return Temp;
		}
		else {
			throw new ExceptionClass("No patient Admitted in that Date with the given Name");
		}
	}

	@Override
	public List<Patient> readNumberOfPatientsByAdmittedDateAndHospitalId(LocalDate date, int id) {
		List<Patient> patients=patientRepository.findPatientsByAdmittedDate(date,id);
		if (patients!=null) {
			return patients;
		}
		else {
			throw new ExceptionClass("No patients admitted in the given date in that hospital");
		}
	}

	@Override
	public String updatePatientBloodGroupById(int id,String bloodGroup) {
		Patient patientTemp=patientRepository.findByPatientId(id);
		if (patientTemp!=null && patientTemp.getPatientId()==id) {
			patientTemp.setPatientBloodGroup(bloodGroup);
			patientRepository.save(patientTemp);
			return "Blood Group Updated";
		}
		else {
			throw new ExceptionClass("The patient not found with the given id");
		}
	}

	@Override
	public List<Patient> deletePatientById(int patientId) {
		patientRepository.setforeignkeyconstrantzero();
		patientRepository.deleteById(patientId);
		return patientRepository.findAll();
		
	}

	@Override
	public List<Patient> readAllPatients() {
		List<Patient> patientList =patientRepository.findAll();
		return patientList;
	}

	@Override
	public int getCurrentPatientIdByMobile(String mobile) {
		Patient patientTemp=patientRepository.findByPatientMobileNumber(mobile);
		return patientTemp.getPatientId();
	}

	@Override
	public Doctor getDoctorWithPatientId(int patientId) {
		Doctor doctor= new Doctor();
		
	int doctorId=	patientRepository.getDoctorWithPatientId(patientId);
	
	doctor=doctorRepository.findDoctorByDoctorId(doctorId);
	
	return doctor;
		
		
	}

	@Override
	public List<String> getAllPatientNames() {
		List<String> patientsNames=new ArrayList<>();
		List<Patient> petients= patientRepository.findAll();
		for (Patient patient : petients) {
			patientsNames.add(patient.getPatientName());
		}
		return patientsNames;
	}

	@Override
	public List<Patient> readAllPatientsByNames(List<String> pnames) {
		
		List<Patient> patients = new ArrayList<Patient>();
		
		for (String name : pnames) {
			
			Patient patientTemp=patientRepository.findPatientByPatientName(name);
			patients.add(patientTemp);
			
		}
		
		return patients;
	}

	@Override
	public List<Patient> readPatientsByAdmittedDate(LocalDate date) {
		 List<Patient> patients=patientRepository.findPatientsByAdmittedDate(date);
		 if(patients==null) {
			 throw new ExceptionClass("No patients admitted on given date");
		 }
		 else {
			 return patients;
		 }
	}
	
	
}
