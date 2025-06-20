package com.example.employee_management_system.pojo;

public class EmployeePojo {

	private String empName;
	
	private Double salary;
	
	private Integer designationId;
	
	private Integer departmentId;

	
	

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	@Override
	public String toString() {
		return "EmployeePojo [empName=" + empName + ", salary=" + salary + ", designationId=" + designationId
				+ ", departmentId=" + departmentId + "]";
	}


	

	
	
	
}
