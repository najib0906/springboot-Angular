import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from '../models/student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  host="http://localhost:8080/api"
  constructor(private client:HttpClient) { }
  public getAllStudents():Observable<Student[]>
  {
    return this.client.get<Student[]>(this.host+"/allstudent")
  }

}
