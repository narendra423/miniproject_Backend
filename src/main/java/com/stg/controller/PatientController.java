package com.stg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Doctor;
import com.stg.entity.Hospital;
import com.stg.entity.Patient;
import com.stg.service.DoctorService;
import com.stg.service.HospitalService;
import com.stg.service.PatientService;

@RestController
@RequestMapping(value = "patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.admitPatient(patient);
	}

	@GetMapping(value = "readById/{id}")
	public Patient readPatientById(@PathVariable int id) {
		return patientService.readPatientById(id);
	}

	@GetMapping(value = "readByNameAndId")
	public Patient readPatientByNameAndId(@RequestParam String patientName, @RequestParam int patientId) {
		return patientService.readPatientByNameAndId(patientName, patientId);
	}
	
	@GetMapping(value="readByNameAndAdmittedDate")
	public Patient readPatientByPatientNameAndAdmittedDate(@RequestParam String name,@RequestParam("localdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localdate) {
		return patientService.readPatientIdByNameAndAdmittedDate(name, localdate);
	}
	
	@GetMapping(value="readByAdmittedDate/{localdate}")
	public List<Patient> readPatientsByAdmittedDate(@PathVariable("localdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localdate) {
		return patientService.readPatientsByAdmittedDate(localdate);
	}
	
	
	
	@GetMapping(value="getPatientsByDateAndHospitalId")
	public List<Patient> readNumberOfPatientsByAdmittedDateAndHospitalId(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate,int id){
		return patientService.readNumberOfPatientsByAdmittedDateAndHospitalId(localDate, id);
	}
	
	@GetMapping(value="getAllPatients")
	public List<Patient> readAllPatients(){
		return patientService.readAllPatients();
	}
	
	
	
	@GetMapping(value="getCurrentPatientId/{mobile}")
	public int getCurrentPatientIdByMobile(@PathVariable String mobile) {
		return patientService.getCurrentPatientIdByMobile(mobile);
	}
	
	@PutMapping(value = "updateBloodGroupById")
	public String updatePatientBloodGroupById(@RequestParam int Id,@RequestParam String bloodGroup) {
		return patientService.updatePatientBloodGroupById(Id, bloodGroup);
	}

	@DeleteMapping(value = "deletePatientById/{id}")
	public List<Patient> deletePatientByPatientId(@PathVariable int id) {
		return patientService.deletePatientById(id);
	}
	
	@GetMapping(value="findDoctorWithPatientId")
	public Doctor getDoctorWithPatientId(@RequestParam int patientId) {
		return patientService.getDoctorWithPatientId(patientId);
	}
	
	@GetMapping(value="getAllPatientNames")
	public List<String> getAllPatientNames(){
		return patientService.getAllPatientNames();
	}
	
	@GetMapping(value="getPatientsByName",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Patient> getPatientsByName(@RequestBody List<String> pnames) {
		return patientService.readAllPatientsByNames(pnames);
	}
	
}
