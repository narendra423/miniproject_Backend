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

import com.stg.entity.Hospital;
import com.stg.service.HospitalService;

@RestController
@RequestMapping(value = "hospital")
@CrossOrigin(origins = "http://localhost:4200")

public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping(value="add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Hospital addHospital(@RequestBody Hospital hospital) {
		return hospitalService.addHospital(hospital);
	}
//	@GetMapping(value="readByCode/{hospitalCode}")
//	public Hospital readHospitalByHospitalCode(@PathVariable String hospitalCode) {
//		return hospitalService.readHospitalByCode(hospitalCode);
//	}
	
	@GetMapping(value="readByHospitalCode/{hospitalCode}")
	public List<Hospital> readHospitalByLocation(@PathVariable String hospitalCode) {
		return hospitalService.readHospitalLocation(hospitalCode);
	}
	
	@GetMapping(value="readByNameAndId")
	public Hospital readHospitalByNameAndId(@RequestParam String hospitalName,@RequestParam int hospitalId) {
		return hospitalService.readHospitalByNameAndId(hospitalName, hospitalId);
	}
	
	@GetMapping(value="getAllHospitals")
	public List<Hospital> getAllHospitals(){
		return hospitalService.getAllHospitals();
	}
	
	
	@PutMapping(value="updateHospitalTypeById/{hospitalId}/{hospitalType}")
	public void updateHospitalById(@PathVariable int hospitalId,@PathVariable String hospitalType) {
		 hospitalService.updateHospitalByHospitalId(hospitalId, hospitalType);
	}
	
	@PostMapping(value="updateHospital",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateHospital(@RequestBody Hospital hospital) {
		return hospitalService.updateHospital(hospital);
	}
	
	@DeleteMapping(value="deleteHospitalById/{id}")	
	public List<Hospital> deleteHospitalById(@PathVariable int id) {
		return hospitalService.deleteHospitalById(id);
	}
	@GetMapping(value = "getHospitalById/{hospitalId}")
	public Hospital getHospitalById(@PathVariable int hospitalId) {
		return hospitalService.readByHospitalId(hospitalId);
	}
}
