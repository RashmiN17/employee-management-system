package com.example.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management_system.pojo.LoginPojo;
import com.example.employee_management_system.pojo.ResponsePojo;
import com.example.employee_management_system.service.LoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	LoginService service;
	
	@PostMapping("login")
	public ResponsePojo login(@RequestBody LoginPojo pojo) {
		return service.login(pojo);
	}
}
