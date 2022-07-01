package com.stg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.stg.entity.Hospital;
import com.stg.exception.ExceptionClass;
import com.stg.repository.DepartmentRepository;
import com.stg.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired
	private HospitalRepository hospitalRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	

	@Override
	public Hospital addHospital(Hospital hospital) throws ExceptionClass {
		hospitalRepository.save(hospital);
		return hospital;
	}

//	@Override
//	public Hospital readHospitalByCode(String hospitalCode) throws ExceptionClass {
//
//		Hospital hospitalTemp = hospitalRepository.findByHospitalCode(hospitalCode);
//		if (hospitalTemp == null) {
//			throw new ExceptionClass("Hospital is not available with the given Id");
//		} else {
//			return hospitalTemp;
//		}
//	}

	@Override
	public Hospital readHospitalByNameAndId(String hospitalName, int hospitalId) throws ExceptionClass {
		Hospital hospitalTemp=hospitalRepository.findByHospitalId(hospitalId);
		if (hospitalTemp!=null && hospitalTemp.getHospitalName().equals(hospitalName)) {
			return hospitalTemp;
		}
		else {
			throw new ExceptionClass("Hospital is not available with the given name and id");
		}
		
	}

	@Override
	public void updateHospitalByHospitalId(int hospitalId,String hospitalType) throws ExceptionClass {
		Hospital hospitalTemp=hospitalRepository.findByHospitalId(hospitalId);
		if (hospitalTemp!=null) {
			hospitalTemp.setHospitalType(hospitalType);
			hospitalRepository.save(hospitalTemp);
			//return "Hospital Updated";
		}
		else {
			throw new ExceptionClass("no Hospital with given Id");
		}
	}


	@Override
	public List<Hospital> deleteHospitalById(int hospitalId) throws ExceptionClass {
		Hospital Temp=hospitalRepository.findByHospitalId(hospitalId);
		if (Temp!=null) {
			hospitalRepository.setforeignkeyconstrantzero();
			departmentRepository.deleteHospitalDepartments(hospitalId);
			hospitalRepository.deleteById(hospitalId);
			return hospitalRepository.findAll();
		}
		else {
			throw new ExceptionClass("No Hospital Found with the Given Id");
		}
	}

	@Override
	public List<Hospital> getAllHospitals() {
		List<Hospital> hospitalsList=hospitalRepository.findAll();
		return hospitalsList;
	}

	@Override
	public List<Hospital> readHospitalLocation(String hospitalCode) {
		List<Hospital> hospitals=hospitalRepository.findByHospitalCode(hospitalCode);
		return hospitals;
	}

	@Override
	public String updateHospital(Hospital hospital) {
			
			//Hospital hospitalTemp=hospitalRepository.findByHospitalId(hospitalId);
			//hospitalTemp=hospital;
			hospitalRepository.save(hospital);
			return "Hospital Updated";
	}

	@Override
	public Hospital readByHospitalId(int hospitalId) {
	
		return 	hospitalRepository.findByHospitalId(hospitalId);
	}

}
