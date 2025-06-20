package com.example.employee_management_system.enums;

public enum DesignationEnum {

	SOFTWARE_DEVLOPER(1),
	TEAM_LEAD(2),
	MANAGER(3),
	SOFTWARE_TESTER(4),
	DEVOPS_ENGINEER(5);
	
	 private final int code;

    // Constructor
    DesignationEnum(int code) {
        this.code = code;
    }

    // Getter
    public int getCode() {
        return code;
    }
	
}
