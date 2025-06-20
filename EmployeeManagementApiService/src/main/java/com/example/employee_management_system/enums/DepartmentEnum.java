package com.example.employee_management_system.enums;

public enum DepartmentEnum {


	HUMAN_RESOURCE_DEPARTMENT(1),
	SOFTWARE_DEVLOPMENT(2),
	DEVOPS(3),
	MARKETING(4),
	QUALITY_ASSURANCE(5);
	
	private final int dept_id;

	public int getDept_id() {
		return dept_id;
	}

	private DepartmentEnum(int dept_id) {
		this.dept_id = dept_id;
	}
	
	

}
