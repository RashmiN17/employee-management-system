package com.example.employee_management_system.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "salary")
	private Double salary;

	@ManyToOne
	@JoinColumn(name = "designation_id", referencedColumnName = "id")
	private DesignationEntity designation;
	
	@ManyToOne
	@JoinColumn(name="dept_id",referencedColumnName = "id")
	private DepartmentEntity department;

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	

	@Override
	public String toString() {
		return "EmployeeEntity [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", designation="
				+ designation + ", department=" + department + "]";
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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

	public DesignationEntity getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationEntity designation) {
		this.designation = designation;
	}
}
