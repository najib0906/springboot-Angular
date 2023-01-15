import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formation } from '../models/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {

  host="http://localhost:8080/api"
  constructor(private client:HttpClient) { }
  public getAllformation():Observable<Formation[]>
  {
    return this.client.get<Formation[]>(this.host+"/allformation")
  }

}

