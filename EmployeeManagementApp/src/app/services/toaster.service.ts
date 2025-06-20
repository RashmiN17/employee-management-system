import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ToasterObject } from '../interface-obj/toaster-object';

@Injectable({
  providedIn: 'root'
})
export class ToasterService {

   constructor(private toasterService: ToastrService) { }

  toaster(tostObj: ToasterObject) {
    
    switch (tostObj.type) {
      case "success":
        this.toasterService.success(tostObj.message, tostObj.title)
        break;
      case "error":
        this.toasterService.error(tostObj.message, tostObj.title)
        break;
      case "info":
        this.toasterService.info(tostObj.message, tostObj.title)
        break;
      case "warning":
        this.toasterService.warning(tostObj.message, tostObj.title)
        break;
    }
  }
}
