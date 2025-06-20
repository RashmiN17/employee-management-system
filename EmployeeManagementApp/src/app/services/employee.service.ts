import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  url: string = 'http://localhost:8080/employee'
  constructor(private http: HttpClient) { }

  getAllEmployees(data: any): Observable<any[]> {
    return this.http.post<any[]>(this.url + "/getAllEmployees", data)
  }
  getDesignationList(): Observable<any[]> {
    return this.http.get<any[]>(this.url + "/getDesginationList")
  }
  getDepartmentList(): Observable<any[]> {
    return this.http.get<any[]>(this.url + "/getDepartmentList")
  }
  addEmployee(data: any): Observable<any> {
    return this.http.post<any>(this.url + "/addEmployee", data)
  }
  updateEmployee(id: number, data: any): Observable<any> {
    return this.http.post<any>(`${this.url}/updateEmployee/${id}`, data)
  }
  deleteEmployee(empId: number): Observable<any> {
    return this.http.delete<any>(`${this.url}/deleteEmployee/${empId}`)
  }
  getEmployeeById(empId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.url}/getEmployeeById/${empId}`)
  }

  login(data: any) {
    return this.http.post<any>("http://localhost:8080/login", data)
  }

}
