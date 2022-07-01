package com.stg.service;

import java.util.List;

import com.stg.entity.Hospital;

public interface HospitalService {
	public abstract Hospital addHospital(Hospital hospital);

	//public abstract Hospital readHospitalByCode(String hospitalCode);
	
	public abstract List<Hospital> readHospitalLocation(String hospitalCode);

	public abstract Hospital readHospitalByNameAndId(String hospitalName, int hospitalId);

	public abstract void updateHospitalByHospitalId(int hospitalId, String hospitalType);
	
	public abstract String updateHospital(Hospital hospital);

	public abstract List<Hospital> deleteHospitalById(int hospitalId);
	
	public abstract List<Hospital> getAllHospitals();
	public abstract Hospital readByHospitalId(int hospitalId);
}
