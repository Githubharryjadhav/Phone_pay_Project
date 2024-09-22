import { Component } from '@angular/core';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  bankDetailsVisible = false;
  bankStatus: string = '';
  accountName: string = '';  // Your name
  accountNumber: string = '';
  bankName: string = '';     // Actual bank name

  constructor() {}

  profile() {
  
  
      this.bankStatus = 'Successfully Linked with Bank';
      this.accountName = 'Harikishan Jadhav';  // Your name in Account Name
      this.accountNumber = '1111';
      this.bankName = 'Bank Of Maharastra Pune Branch';  // Replace 'Your Bank Name' with the actual bank name
      this.bankDetailsVisible = true; // Show the bank details
    }
  } 


