package com.example.employee_management_system.pojo;

import java.util.List;

public class CommonGetPayloadPojo {

	private String search;
	
	private Integer noOfRecords;
	
	private List<Integer> designationFilter;
	
	private List<Integer> departmentFilter;
	
	public List<Integer> getDepartmentFilter() {
		return departmentFilter;
	}

	public void setDepartmentFilter(List<Integer> departmentFilter) {
		this.departmentFilter = departmentFilter;
	}

	private Integer pageNo;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getNoOfRecords() {
		return noOfRecords;
	}

	public void setNoOfRecords(Integer noOfRecords) {
		this.noOfRecords = noOfRecords;
	}

	public List<Integer> getDesignationFilter() {
		return designationFilter;
	}

	public void setDesignationFilter(List<Integer> designationFilter) {
		this.designationFilter = designationFilter;
	}

	@Override
	public String toString() {
		return "CommonGetPayloadPojo [search=" + search + ", noOfRecords=" + noOfRecords + ", designationFilter="
				+ designationFilter + ", departmentFilter=" + departmentFilter + ", pageNo=" + pageNo + "]";
	}

	

	
	
	
}
