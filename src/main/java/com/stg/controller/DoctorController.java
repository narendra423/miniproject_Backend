package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.stg.entity.Patient;
import com.stg.service.DoctorService;

@RestController
@RequestMapping(value="doctor")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping(value="addDoctor",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	
	@GetMapping(value="readDoctorById/{id}")
	public Doctor readDoctorById(@PathVariable int id) {
		return doctorService.readDoctorById(id);
	}
	
	@GetMapping(value="getAllDoctors")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	
	@GetMapping(value="readDoctorByNameAndId")
	public Doctor readDoctorByNameAndId(@RequestParam String name,@RequestParam int id) {
		return doctorService.readDoctorByNameAndId(name, id);
	}
	
	@GetMapping(value="readDoctorId")
	public int readDoctorIdByNameAndSpecialization(@RequestParam String doctorName,@RequestParam String specialization) {
		return doctorService.readDoctorIdByDoctorNameAndSpecialization(doctorName, specialization);
	}
	
	@PutMapping(value="updateDoctorSpecilization")
	public String updateDoctorSpecialization(@RequestParam String doctorSpecialization,@RequestParam int id) {
		return doctorService.updateDoctorSpecializationByDoctorId(doctorSpecialization, id);
	}
	
	@PutMapping(value="updateDoctorAgeById")
	public String updateDoctorAgeByDoctorId(@RequestParam int age,int id) {
		return doctorService.updateDoctorAgeByDoctorId(age, id);
	}
	
	@DeleteMapping(value="deleteDoctor/{id}")
	public List<Doctor> deleteDoctor(@PathVariable int id) {
		return doctorService.deleteDoctorById(id);
	}
	
	@PutMapping(value="assignPatientstoDoctor/{doctorId}")
	public Doctor assignPatientstoDoctor(@RequestBody List<Patient> patients,@PathVariable int doctorId){
		return doctorService.assignPatientstoDoctor(patients, doctorId);
	}
	
	@PutMapping(value="assignPatientstoDoctorWithId")
	public Doctor assignPatientstoDoctor(@RequestParam int patientId,@RequestParam int doctorId){
		return doctorService.assignPatientstoDoctorWithId(patientId, doctorId);
	}
	@GetMapping(value="getPatients")
	public List<Patient> getPatientsByDoctorId(@RequestParam int doctorId) {
		return doctorService.getPatientsByDoctorId(doctorId);
	}
}
