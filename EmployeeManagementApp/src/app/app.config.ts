import { ApplicationConfig, importProvidersFrom, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { routes } from './app.routes';
import { HttpClientModule } from '@angular/common/http';
import { SharedModuleModule } from './shared-module/shared-module.module';
export const appConfig: ApplicationConfig = {
 providers: [provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes), importProvidersFrom(
      BrowserAnimationsModule,
      HttpClientModule,
      SharedModuleModule,
       // ✅ Import your NgModule here
    )]
};
