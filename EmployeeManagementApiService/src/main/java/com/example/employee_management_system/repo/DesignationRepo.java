package com.example.employee_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_management_system.entity.DesignationEntity;

@Repository
public interface DesignationRepo extends JpaRepository<DesignationEntity, Integer>{

}
