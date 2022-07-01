package com.stg.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.entity.Doctor;
import com.stg.entity.Patient;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	public Doctor findDoctorByDoctorId(int id);
	public Doctor findDoctorByDoctorNameAndDoctorSpecialization(String name,String specialization);

}
