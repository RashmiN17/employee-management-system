package com.example.employee_management_system.pojo;

import java.util.HashMap;

public class ResponsePojo {

	private boolean status;
	
	private Object data;
	
	private String message;
	
	private HashMap<String,Object> extraMap;
	
	private Integer totalRecords;
	

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	

	@Override
	public String toString() {
		return "ResponsePojo [status=" + status + ", data=" + data + ", message=" + message + ", extraMap=" + extraMap
				+ ", totalRecords=" + totalRecords + "]";
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HashMap<String, Object> getExtraMap() {
		return extraMap;
	}

	public void setExtraMap(HashMap<String, Object> extraMap) {
		this.extraMap = extraMap;
	}
}
