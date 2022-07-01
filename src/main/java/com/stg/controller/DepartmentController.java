package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.stg.entity.Department;
import com.stg.entity.Hospital;
import com.stg.service.DepartmenmentService;

@RestController
@RequestMapping(value="department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
	@Autowired
	private DepartmenmentService departmenmentService;
	
	@PostMapping(value="addDepartment")
	public Department addDepartment(@RequestBody Department department) {
		return departmenmentService.addDepartment(department);
	}
	
	@GetMapping(value="readDepartment/{id}")
	public Department readDepartmentById(@PathVariable int id) {
		return departmenmentService.readDepartmentById(id);
	}
	
	@GetMapping(value="readDeptByNameAndId")
	public Department readDepartmentByNameAndId(@RequestParam String name,@RequestParam int id) {
		return departmenmentService.readDepartmentByNameAndId(name,id);
	}
	
	
	  @GetMapping(value="getAllDepartments") public List<Department>
	  getAllDepartments(){ return
	  departmenmentService.getAllDepartments(); }
	 
	
	@PutMapping(value="updateFloorById/{newFloor}/{id}")
	public String updateFloorById(@PathVariable String newFloor,@PathVariable int id) {
		return departmenmentService.updateDepartmentDeptFloorByDepartmentId(newFloor,id);
	}
	
	@DeleteMapping(value="deleteDepartment/{id}")
	public List<Department> deleteDepartmentById(@PathVariable int id) {
		return departmenmentService.deleteDepartmentById(id);
	}
}
