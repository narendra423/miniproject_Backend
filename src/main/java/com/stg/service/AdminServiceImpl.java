package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Admin;
import com.stg.exception.ExceptionClass;
import com.stg.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public String addAdmin(Admin admin) {
		Admin adminTemp=adminRepository.findByHospitalCode(admin.getHospitalCode());
		if(adminTemp==null) {
			adminRepository.save(admin);
			return "success";
		}
		else {
			throw new ExceptionClass("Duplicate Admin found");
		}
	}

	@Override
	public Admin getAdmin(String email, String password) {
		Admin adminTemp=adminRepository.findByAdminEmail(email);
		
		if (adminTemp!=null && adminTemp.getPassword().equals(password)) {
			return adminTemp;
		}
		else {
			throw new ExceptionClass("Admin doesn't exist with the Given mail Id");
		}
		
	}

	@Override
	public List<Admin> getAllAdmins() {
		List<Admin> adminsList=adminRepository.findAll();
		return adminsList;
	}
	

}
