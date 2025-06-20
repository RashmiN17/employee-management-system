package com.example.employee_management_system.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management_system.dao.LoginDao;
import com.example.employee_management_system.pojo.LoginPojo;
import com.example.employee_management_system.pojo.ResponsePojo;
import com.example.employee_management_system.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;
	
	@Override
	public ResponsePojo login(LoginPojo pojo) {
		
		return dao.login(pojo);
	}

}
