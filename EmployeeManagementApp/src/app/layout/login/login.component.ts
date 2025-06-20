import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SharedModuleModule } from '../../shared-module/shared-module.module';
import { ToasterService } from '../../services/toaster.service';
import { Router } from '@angular/router';
import { LoginObject } from '../../interface-obj/toaster-object';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-login',
  imports: [SharedModuleModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup
  submitted = false;
  showPassword: boolean = false;
  loginObject: LoginObject = <LoginObject>{}
  constructor(public fb: FormBuilder, private toasterService: ToasterService, private router: Router, private service: EmployeeService) {
    this.loginForm = fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
  }
  ngOnInit(): void {

  }

  onSubmit() {

    const { username, password } = this.loginForm.value;
    this.loginObject.username = username;
    this.loginObject.password = password;



    if (username == "admin" && password == "admin@123") {
      this.router.navigate(['admin'])
      this.toasterService.toaster({ type: "success", title: "Success", message: "Logged In Successfully" })
      this.loginForm.reset()
    }
    else {
      this.service.login(this.loginObject).subscribe((res: any) => {
        if (res.status) {
          this.router.navigate(['admin'])
          this.toasterService.toaster({ type: "success", title: "Success", message: res.message })
          this.loginForm.reset()
        } else {
          this.toasterService.toaster({ type: "error", title: "Error", message:res.message })
          this.loginForm.reset()
        }
      },err=>{
        console.log(err);
        
      })

    }
  }

  get f() {
    return this.loginForm.controls;
  }

  togglePassword(): void {
    this.showPassword = !this.showPassword;
  }

}
