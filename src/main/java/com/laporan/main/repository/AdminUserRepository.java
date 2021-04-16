package com.laporan.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.laporan.main.entity.AdminUser;


public interface AdminUserRepository extends CrudRepository<AdminUser, Long> {
	public AdminUser findByUsername(String username);
}
