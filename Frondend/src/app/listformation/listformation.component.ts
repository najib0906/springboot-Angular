import { Component , OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Formation } from '../models/formation';
import { FormationService } from '../service/formation.service';

@Component({
  selector: 'app-listformation',
  templateUrl: './listformation.component.html',
  styleUrls: ['./listformation.component.css']
})
export class ListformationComponent implements OnInit{

  constructor(private service:FormationService , private router : Router){}

  Formation!:Formation[];
  ngOnInit(): void {
    this.service.getAllformation().subscribe(data=>this.Formation=data)
  }
  listestudent(){
    this.router.navigate(["/listestudent"])
  }
  

}
