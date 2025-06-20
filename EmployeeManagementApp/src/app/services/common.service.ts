import { Injectable } from '@angular/core';
import { CommonGetPayLoad, PaginationObj } from '../interface-obj/toaster-object';
import { IDropdownSettings } from 'ng-multiselect-dropdown';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  noOfRecords: number = 5;
  commonGetPayload: CommonGetPayLoad = <CommonGetPayLoad>{}
  paginationObj: PaginationObj = <PaginationObj>{}

  constructor() { }

  setAPIDefaultValues(): CommonGetPayLoad {
    this.commonGetPayload.designationFilter = [];
    this.commonGetPayload.departmentFilter=[]
    this.commonGetPayload.noOfRecords = 5;
    this.commonGetPayload.search = ""
    this.commonGetPayload.pageNo = 0

    return this.commonGetPayload
  }

  setPaginationObj(): PaginationObj {
    this.paginationObj.pageIndex = 0;
    this.paginationObj.totalRecords = 0;

    return this.paginationObj
  }

  getDropDownSettingWithSearch(idField: string, textField: string): IDropdownSettings {
    let dropdownSettings: IDropdownSettings

    dropdownSettings = {
      singleSelection: false,
      idField:idField,
      textField:textField,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true // ✅ Enables search
    };

    return dropdownSettings;
  }
}
