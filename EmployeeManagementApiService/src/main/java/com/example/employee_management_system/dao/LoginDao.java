package com.example.employee_management_system.dao;

import com.example.employee_management_system.pojo.LoginPojo;
import com.example.employee_management_system.pojo.ResponsePojo;

public interface LoginDao {

	ResponsePojo login(LoginPojo pojo);
}
