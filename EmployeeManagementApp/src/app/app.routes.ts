import { Routes } from '@angular/router';
import { LoginComponent } from './layout/login/login.component';
import { AdminModule } from './admin/admin/admin.module';

export const routes: Routes = [
    {
        path:"",
        component:LoginComponent
    },
    {
        path:"admin",
        loadChildren:()=> import('./admin/admin/admin.module').then(m=>m.AdminModule)
    }
];
