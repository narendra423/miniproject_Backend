package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Admin;
import com.stg.entity.Hospital;
import com.stg.service.AdminService;

@RestController
@RequestMapping(value="admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value="addAdmin",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@GetMapping(value="getAdmin/{email}/{password}")
	public Admin getAdmin(@PathVariable String email,@PathVariable String password) {
		return adminService.getAdmin(email, password);
	}
		
	@GetMapping(value="getAllAdmins")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
}
