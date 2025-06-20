package com.example.employee_management_system.service;

import com.example.employee_management_system.pojo.LoginPojo;
import com.example.employee_management_system.pojo.ResponsePojo;

public interface LoginService {

	ResponsePojo login(LoginPojo pojo);

}
