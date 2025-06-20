import { Component, Input, OnInit } from '@angular/core';
import { SharedModuleModule } from '../../shared-module/shared-module.module';
import { NgForm } from '@angular/forms';
import { Department, Designation, Employee } from '../../interface-obj/toaster-object';
import { EmployeeService } from '../../services/employee.service';
import { ToasterService } from '../../services/toaster.service';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmationComponent } from '../../layout/confirmation/confirmation.component';

@Component({
  selector: 'app-add-update-employee',
  imports: [SharedModuleModule],
  templateUrl: './add-update-employee.component.html',
  styleUrl: './add-update-employee.component.scss'
})
export class AddUpdateEmployeeComponent implements OnInit {
  @Input() dataObj: any = {}
  employee: Employee = <Employee>{}
  designations: Designation[] = [];
  departmentList: Department[] = []

  constructor(private employeeService: EmployeeService,
    private toasterService: ToasterService,
    private ngbActiveModal: NgbActiveModal,
    private ngnModal: NgbModal) { }

  ngOnInit(): void {
    console.log("dataObj", this.dataObj);

    this.loadDesignations();
    this.loadDepartmentList()
    if (this.dataObj.operation == "Update") {
      this.getEmployeeById()
    }
  }

  loadDesignations(): void {
    this.employeeService.getDesignationList().subscribe((res: any) => {
      if (res.status) {
        this.designations = res.data;
      }
    });
  }

  loadDepartmentList(): void {
    this.employeeService.getDepartmentList().subscribe((res: any) => {
      if (res.status) {
        this.departmentList = res.data;
        console.log("department list", this.departmentList);


      }
    });
  }

  onSubmit(): void {
    if (this.dataObj.operation == "Update") {
      this.onUpdateEmployee()
    } else {
      this.onAddEmployee()
    }
  }


  getEmployeeById() {
    this.employeeService.getEmployeeById(this.dataObj.empId).subscribe((res: any) => {
      if (res.status) {
        this.employee = {
          empId: res.data.empId,
          empName: res.data.empName,
          salary: res.data.salary,
          designationId: res.data.designation.id,
          departmentId: res.data.department.id
        };
        console.log("Fetched Employee By Id");

      } else {
        console.log("Erro");

      }
    }, err => {
      console.log(err);

    })
  }

  closeForm(status: boolean) {
    this.ngbActiveModal.close({ status: status })
  }

  onAddEmployee() {
    const openModal = this.ngnModal.open(ConfirmationComponent, { backdrop: 'static', size: 'md', centered: true })
    openModal.componentInstance.message = "You want to add employee "
    openModal.componentInstance.title = "Are you sure"
    openModal.result.then((res: any) => {
      console.log(res);
      if (res) {
        this.employeeService.addEmployee(this.employee).subscribe((res: any) => {
          if (res.status) {
            this.toasterService.toaster({ type: "success", title: "Success", message: res.message })
            this.closeForm(true)
          }
          else {
            this.toasterService.toaster({ title: "Error", type: "error", message: res.message })
          }

        });
      }

    })
  }

  onUpdateEmployee() {
    const openModal = this.ngnModal.open(ConfirmationComponent, { backdrop: 'static', size: 'md', centered: true })
    openModal.componentInstance.message = "You want to update employee "
    openModal.componentInstance.title = "Are you sure"
    openModal.result.then((res: any) => {
      console.log(res);
      if (res) {
        this.employeeService.updateEmployee(this.employee.empId, this.employee).subscribe((res: any) => {
          if (res.status) {
            this.closeForm(true)
            this.toasterService.toaster({ type: "success", title: "Success", message: res.message })
          } else {
            this.toasterService.toaster({ title: "Error", type: "error", message: res.message })
          }


        }, err => {
          console.log(err);

        });
      }

    })
  }

}
