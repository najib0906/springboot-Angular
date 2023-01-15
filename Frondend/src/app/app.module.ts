import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {  HttpClientModule } from '@angular/common/http';
import { ListeStudentComponent } from './liste-student/liste-student.component';
import { ListformationComponent } from './listformation/listformation.component';


@NgModule({
  declarations: [
    AppComponent,
    ListeStudentComponent,
    ListformationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
