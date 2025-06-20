import { NgModule } from '@angular/core';
import { CommonModule, NgFor, NgIf, NgSwitch } from '@angular/common';
import {MatPaginatorModule} from '@angular/material/paginator'
import { NgxSpinnerModule } from 'ngx-spinner';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { EmployeeService } from '../services/employee.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatPaginatorModule,
   NgxSpinnerModule.forRoot({ type: 'ball-scale-multiple' }),
    ToastrModule.forRoot({
      positionClass: 'toast-bottom-right',
      timeOut: 3000,
      progressBar:true,
      progressAnimation:"increasing",
      closeButton:true
    }),
    FormsModule,
    ReactiveFormsModule,
    NgIf,NgFor,NgSwitch,
    NgbModule,
     NgMultiSelectDropDownModule.forRoot()

  ],
  exports:[
    CommonModule,
    MatPaginatorModule,
    NgxSpinnerModule,
    ToastrModule,
    FormsModule,
    ReactiveFormsModule,
    NgFor,NgIf,NgSwitch,
     NgMultiSelectDropDownModule
  ],
  providers:[EmployeeService]
})
export class SharedModuleModule { }
