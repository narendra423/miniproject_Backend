package com.stg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.Doctor;
import com.stg.entity.Hospital;
import com.stg.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public Patient findByPatientId(int Id);
	public Patient findByPatientMobileNumber(String mno);

	@Query(value = "select * from patient p where p.admitted_date=?1", nativeQuery = true)
	public Patient findByPatientAdmittedDate(LocalDate date);
	
	@Query(value="select * from patient p where p.admitted_date=?1 and hospital_id=?2",nativeQuery = true)
	public List<Patient> findPatientsByAdmittedDate(LocalDate date,int id);
	public List<Patient> findPatientsByAdmittedDate(LocalDate date);
	
	@Query(value="select doctor_id from doctor_patients t1 inner join patient t2 where t2.patient_id=?1 group by t2.patient_id"
			,nativeQuery = true)
	public int getDoctorWithPatientId(int patientId);
	public Patient findPatientByPatientName(String pname);
	
	@Modifying
	@Transactional
	@Query(value = "set FOREIGN_KEY_CHECKS=0;",nativeQuery = true )
	public abstract void setforeignkeyconstrantzero();
}
