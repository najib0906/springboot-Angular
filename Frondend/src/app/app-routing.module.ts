import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListeStudentComponent } from './liste-student/liste-student.component';
import { ListformationComponent } from './listformation/listformation.component';

const routes: Routes = [
  {path:"listestudent" , component: ListeStudentComponent} , 
  {path:"listformation" , component:ListformationComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
