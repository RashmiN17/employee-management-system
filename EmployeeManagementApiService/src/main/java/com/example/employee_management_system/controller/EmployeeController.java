package com.example.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management_system.pojo.CommonGetPayloadPojo;
import com.example.employee_management_system.pojo.EmployeePojo;
import com.example.employee_management_system.pojo.ResponsePojo;
import com.example.employee_management_system.service.EmployeeService;

@RestController
@RequestMapping("employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("getAllEmployees")
	public ResponsePojo getAllEmployees(@RequestBody CommonGetPayloadPojo pojo) {
		return service.getAllEmployees(pojo);
	}
	
	@GetMapping("getDesginationList")
	public ResponsePojo getDesignationList() {
		return service.getDesignationList();
	}
	
	@PostMapping("addEmployee")
	public ResponsePojo addEmployee(@RequestBody EmployeePojo pojo) {
		return service.addEmployee(pojo);
	}
	
	@PostMapping("updateEmployee/{empId}")
	public ResponsePojo updateEmployee(@PathVariable Integer empId,@RequestBody EmployeePojo pojo)
	{
		return service.updateEmployee(empId,pojo);
	}
	
	@DeleteMapping("deleteEmployee/{empId}")
	public ResponsePojo deleteEmployee(@PathVariable Integer empId)
	{
		return service.deleteEmployee(empId);
	}
	
	@GetMapping("getEmployeeById/{empId}")
	public ResponsePojo getEmployeeById(@PathVariable Integer empId) {
		return service.getEmployeeById(empId);
	}
	
	@GetMapping("getDepartmentList")
	public ResponsePojo getDepartmentList() {
		return service.getDepartmentList();
	}
	
}
