import { Component , OnInit } from '@angular/core';
import { Student } from '../models/student';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-liste-student',
  templateUrl: './liste-student.component.html',
  styleUrls: ['./liste-student.component.css']
})
export class ListeStudentComponent implements OnInit {
  students!:Student[]
  studentsf!:Student[] 
  
  constructor(private service:StudentService) {}
  ngOnInit():void {
    this.service.getAllStudents().subscribe(data=>{
      this.students=data
      this.studentsf=data
    })
  }
}
