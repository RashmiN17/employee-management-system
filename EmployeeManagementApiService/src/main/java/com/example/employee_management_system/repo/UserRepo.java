package com.example.employee_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_management_system.entity.UsersEntity;

public interface UserRepo extends JpaRepository<UsersEntity,Integer> {
	
	UsersEntity findByUsername(String username);

}
