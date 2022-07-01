package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query(value="select * from admin a where a.admin_email=?1",nativeQuery = true)
	public Admin findByAdminEmail(String adminEmail);
	public Admin findByHospitalCode(String hospitalCode);
}
