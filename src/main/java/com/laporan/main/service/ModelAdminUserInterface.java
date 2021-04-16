package com.laporan.main.service;

import java.util.List;

import com.laporan.main.entity.AdminUser;


public interface ModelAdminUserInterface {
	
	public List<AdminUser> getAllAdminUser();
	
	public AdminUser addAdminUser(AdminUser mahasiswa);
	public AdminUser getAdminUserById(String id);
	public void deleteAdminUser(String id);

}
