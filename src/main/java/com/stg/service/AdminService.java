package com.stg.service;

import java.util.List;

import com.stg.entity.Admin;


public interface AdminService {
	public abstract String addAdmin(Admin admin);
	public abstract Admin getAdmin(String email,String password);
	public abstract List<Admin> getAllAdmins();
}
