package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Department;
import com.stg.entity.Hospital;
import com.stg.exception.ExceptionClass;
import com.stg.repository.DepartmentRepository;
import com.stg.repository.HospitalRepository;

@Service
public class DepartmentServiceImpl implements DepartmenmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public Department addDepartment(Department department) {
		//Department temp=departmentRepository.findByDeptId(department.getDeptId());
		//if (temp==null) {
			departmentRepository.save(department);
			return department;
		}
//		else {
//			throw new ExceptionClass("Department is already found with given ID");
//		}
//	}

	@Override
	public Department readDepartmentById(int id) {
		Department Temp=departmentRepository.findByDeptId(id);
		if (Temp!=null) {
			return Temp;
		}
		else {
			throw new ExceptionClass("No Department Found with the Given ID");
		}
	}

	@Override
	public Department readDepartmentByNameAndId(String Name, int id) {
		Department Temp=departmentRepository.findByDeptId(id);
		if (Temp!=null && Temp.getDeptName().equals(Name)) {
			return Temp;
		}
		else {
			throw new ExceptionClass("No Department Found with given Id and name");
		}
	}

	@Override
	public String updateDepartmentDeptFloorByDepartmentId(String deptFloor, int id) {
		Department Temp=departmentRepository.findByDeptId(id);
		if (Temp!=null) {
			Temp.setFloor(deptFloor);
			departmentRepository.save(Temp);
			return "success";
		}
		else {
			throw new ExceptionClass("No Department Found with that Id");
		}
	}

	@Override
	public List<Department> deleteDepartmentById(int id) {
		Department Temp=departmentRepository.findByDeptId(id);
		if (Temp!=null) {
			departmentRepository.delete(Temp);
			return departmentRepository.findAll();
		}
		else {
			throw new ExceptionClass("No Department Found with the given ID");
		}
	}

	@Override
	public Department assignDoctor(int deptId, int doctorId) {
		
		return null;
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}


	
	
	
}
