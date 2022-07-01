package com.stg.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stg.entity.Department;
import com.stg.entity.Hospital;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	public abstract Department findByDeptId(int id);
//	public abstract Hospital findByHospitalCode(String code);
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM department d WHERE d.hospital_fk=?1", nativeQuery = true)
	public abstract void deleteHospitalDepartments(int hospital_fk);
}
