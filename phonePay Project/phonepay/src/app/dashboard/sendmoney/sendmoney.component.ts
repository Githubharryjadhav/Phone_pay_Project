import { Component } from '@angular/core';
import { SendTransaction } from 'src/app/send-transaction';
import { HttpClient } from '@angular/common/http';
import { LoginComponent } from 'src/app/login/login.component';

@Component({
  selector: 'app-sendmoney',
  templateUrl: './sendmoney.component.html',
  styleUrls: ['./sendmoney.component.css']
})
export class SendmoneyComponent {


  trobj:SendTransaction= new SendTransaction();

  baseUrl='http://localhost:8080/';


  constructor(private http:HttpClient) {
    
  }
  


  SendMoney()
  {
    
    this.http.post(this.baseUrl+"addmoney",this.trobj).subscribe(
      (data:any) => {
        if(data==true)
          window.alert("Transaction Successfull")
        else
        window.alert("Transaction Failed")
      }
    )
      
  }







}
