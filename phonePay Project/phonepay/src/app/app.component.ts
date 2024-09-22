import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'projectphonepay';
  http:any;
  whatToShow:number=1;
  baseUrl='http://localhost:8080/';
  
  userName:string='';
  bankAccounts:any[]=[];

  constructor(){}
}
