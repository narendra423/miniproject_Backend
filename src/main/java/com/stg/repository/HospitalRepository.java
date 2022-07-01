package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	public abstract Hospital findByHospitalId(int hospitalId);
	public abstract List<Hospital> findByHospitalCode(String hospitalCode);
	public abstract Hospital findByHospitalNameAndHospitalId(String hospitalName,int hospitalId);
	
	public abstract List<Hospital> findByHospitalLocation(String hospitalLocation);
	
	
	
	@Modifying
	@Transactional
	@Query(value = "set FOREIGN_KEY_CHECKS=0;",nativeQuery = true )
	public abstract void setforeignkeyconstrantzero();
}
