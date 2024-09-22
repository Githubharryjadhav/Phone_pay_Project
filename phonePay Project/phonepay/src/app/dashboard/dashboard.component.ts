import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  currentcomponent: string = '';

  constructor(private http: HttpClient) {}

  profile() {
    this.currentcomponent = 'profile';
  }

  bankaccount() {
    this.currentcomponent = 'bankaccount';
  }

  sendmoney() {
    this.currentcomponent = 'sendmoney';
  }

  history() {
    this.currentcomponent = 'history';
  }
}
