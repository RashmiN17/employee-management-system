package com.example.employee_management_system.dao;

import com.example.employee_management_system.pojo.CommonGetPayloadPojo;
import com.example.employee_management_system.pojo.EmployeePojo;
import com.example.employee_management_system.pojo.ResponsePojo;

public interface EmployeeDao {

	public ResponsePojo getAllEmployees(CommonGetPayloadPojo pojo);

	public ResponsePojo getDesignationList();

	public ResponsePojo addEmployee(EmployeePojo pojo);

	public ResponsePojo updateEmployee(Integer empId,EmployeePojo pojo);

	public ResponsePojo deleteEmployee(Integer empId);

	public ResponsePojo getEmployeeById(Integer empId);

	public ResponsePojo getDepartmentList();

}
