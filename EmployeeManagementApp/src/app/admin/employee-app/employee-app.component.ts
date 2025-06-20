import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { SharedModuleModule } from '../../shared-module/shared-module.module';
import { ToasterService } from '../../services/toaster.service';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddUpdateEmployeeComponent } from '../add-update-employee/add-update-employee.component';
import { ConfirmationComponent } from '../../layout/confirmation/confirmation.component';
import { CommonGetPayLoad, Department, PaginationObj } from '../../interface-obj/toaster-object';
import { CommonService } from '../../services/common.service';


@Component({
  selector: 'app-employee-app',
  imports: [SharedModuleModule],
  templateUrl: './employee-app.component.html',
  styleUrl: './employee-app.component.scss'
})
export class EmployeeAppComponent implements OnInit {


  commonGetPayload: CommonGetPayLoad = <CommonGetPayLoad>{}
  paginationObj: PaginationObj = <PaginationObj>{}
  constructor(private service: EmployeeService, private toasterService: ToasterService,
    private router: Router, private ngbModal: NgbModal, public commonService: CommonService) { }
  employeeList: any[] = []
  noOfRecords: number = 5
  pageIndex = 0
  paginatedData: any
  isFilterOpen: boolean = false;
  departmentList: any[] = []
  selectedDepartments:any[] = [];
  ngOnInit(): void {
    this.commonGetPayload = this.commonService.setAPIDefaultValues()
    this.paginationObj = this.commonService.setPaginationObj()
    this.getAllEmployees()
    this.loadDepartmentList()
  }
  onItemSelect(item: any) {

    this.commonGetPayload.departmentFilter=this.selectedDepartments.map(dept=>dept.id) 
  console.log(this.commonGetPayload.departmentFilter);
  
  }

  onSelectAll(items: any) {
     this.commonGetPayload.departmentFilter=this.selectedDepartments.map(dept=>dept.id)
  }
  onItemDeselect(item:any) {
  this.commonGetPayload.departmentFilter = this.commonGetPayload.departmentFilter.filter(id => id !== item.id);
  console.log(this.commonGetPayload.departmentFilter);
  
}

  onDeselectAll() {
  this.commonGetPayload.departmentFilter= [];
}


getAllEmployees() {
  this.service.getAllEmployees(this.commonGetPayload).subscribe((res: any) => {
    if (res.status) {
      this.employeeList = res.data
      this.paginationObj.totalRecords = res.totalRecords;
      // this.toasterService.toaster({ type: "success", title: "Success", message: res.message })
    } else {
      // this.toasterService.toaster({ title: "Error", type: "error", message: res.message })
    }
  }, (err: any) => {
    console.log(err);

  })
}

updatePaginationData() {
  const startIndex = this.pageIndex * this.noOfRecords;
  const endIndex = startIndex + this.noOfRecords;
  this.paginatedData = this.employeeList.slice(startIndex, endIndex)
}

logout() {
  const openModal = this.ngbModal.open(ConfirmationComponent, { backdrop: 'static', size: 'md', centered: true })
  openModal.componentInstance.message="Are you sure you want to logout"
  openModal.componentInstance.title="Submit"
  openModal.result.then((res: any) => {
    console.log(res);
      this.router.navigate([''])
  })
  
}

onPageChange(event: PageEvent) {
  this.noOfRecords = event.pageSize;
  this.pageIndex = event.pageIndex;
  this.updatePaginationData();
}

openForm(operation: any, empId ?: any) {
  let dataObj: any = {
    "operation": operation,
    "empId": empId
  }
  const openModal = this.ngbModal.open(AddUpdateEmployeeComponent, { backdrop: 'static', size: 'md', centered: true })
  openModal.componentInstance.dataObj = dataObj
  openModal.result.then((res: any) => {
    if (res.status) {
      this.getAllEmployees()
    }
  })
}

deleteEmployee(empId: number) {
  const openModal = this.ngbModal.open(ConfirmationComponent, { backdrop: 'static', size: 'md', centered: true })
  openModal.componentInstance.message = "You want to Delete Employee"
  openModal.componentInstance.title = "Are you Sure"
  openModal.result.then((res: any) => {
    if (res) {
      this.service.deleteEmployee(empId).subscribe((res: any) => {

        if (res.status) {
          this.toasterService.toaster({ type: "success", title: "Success", message: res.message })
          this.getAllEmployees()
        }
        else {
          this.toasterService.toaster({ title: "Error", type: "error", message: res.message })
        }
      }, err => {
        console.log(err);

      })
    }

  })

}


handlePageEvent(event: PageEvent) {
  this.paginationObj.pageEvent = event;
  this.paginationObj.totalRecords = event.length;
  this.commonGetPayload.pageNo = event.pageIndex;

  this.getAllEmployees()
}

onSearch(event: any) {
  let search: string = event.target.value;
  console.log("search", search);
  if (search.length > 3) {
    this.commonGetPayload.pageNo=0;
    this.commonGetPayload.search = search;
    this.getAllEmployees()
  } else if (search.length == 0) {
    this.commonGetPayload.search = search
    this.getAllEmployees()
  }

}
loadDepartmentList(): void {
  this.service.getDepartmentList().subscribe((res: any) => {
    if (res.status) {
      this.departmentList = res.data;
      console.log("department list", this.departmentList);


    }
  });
}

openFilter() {
  this.isFilterOpen = !this.isFilterOpen
}
onSelect(event: any) {
  console.log(event);

}

onChange() {
  this.commonGetPayload.pageNo=0;
  this.commonGetPayload.departmentFilter=this.selectedDepartments.map(dept=>dept.id)
  this.getAllEmployees()
}
}
