package com.stg.service;

import java.util.List;

import com.stg.entity.Department;
import com.stg.entity.Doctor;
import com.stg.entity.Hospital;

public interface DepartmenmentService {
	public abstract Department addDepartment(Department department);
	public abstract Department readDepartmentById(int id);
	public abstract Department readDepartmentByNameAndId(String Name,int id);
	public abstract String updateDepartmentDeptFloorByDepartmentId(String deptFloor,int id);
	public abstract List<Department> deleteDepartmentById(int id);
	public abstract Department assignDoctor(int deptId, int doctorId);
	public abstract List<Department> getAllDepartments();
	
	
}
