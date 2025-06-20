import { PageEvent } from "@angular/material/paginator";

export interface ToasterObject {
message:string,
type:string,
title:string
}

export interface Employee {
  empId: number; // optional for new entries
  empName: string;
  salary: number;
  designationId: Designation;
  departmentId:Department
}

export interface Designation {
  id: number;
  name: string;
}
export interface Department {
  id: number;
  name: string;
  code:string
}

export interface CommonGetPayLoad{
  search:string,
  noOfRecords:number,
  designationFilter:number[],
  departmentFilter:number[],
  pageNo:number
}

export interface PaginationObj{
  pageEvent:PageEvent,
  totalRecords:number,
  pageIndex:number

}

export interface LoginObject{
  username:string,
  password:string
}
