package com.example.employee_management_system.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management_system.dao.EmployeeDao;
import com.example.employee_management_system.pojo.CommonGetPayloadPojo;
import com.example.employee_management_system.pojo.EmployeePojo;
import com.example.employee_management_system.pojo.ResponsePojo;
import com.example.employee_management_system.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	@Override
	public ResponsePojo getAllEmployees(CommonGetPayloadPojo pojo) {
		
		return dao.getAllEmployees(pojo);
	}

	@Override
	public ResponsePojo getDesignationList() {
		
		return dao.getDesignationList();
	}

	@Override
	public ResponsePojo addEmployee(EmployeePojo pojo) {
		
		return dao.addEmployee(pojo);
	}

	@Override
	public ResponsePojo updateEmployee(Integer empId,EmployeePojo pojo) {
		
		return dao.updateEmployee(empId,pojo);
	}

	@Override
	public ResponsePojo deleteEmployee(Integer empId) {
		
		return dao.deleteEmployee(empId);
	}

	@Override
	public ResponsePojo getEmployeeById(Integer empId) {
		
		return dao.getEmployeeById(empId);
	}

	@Override
	public ResponsePojo getDepartmentList() {
		
		return dao.getDepartmentList();
	}

}
