import { Component } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient } from '@angular/common/http';




@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  showOtp:number=0;
  number: any;
  otp: any;
  bankAccounts:any[]=[];
  userOtp:number=0;

  senderMobile:any;
  
   
    constructor(public app:AppComponent,private http: HttpClient){
    }
      register()
      {
        this.app.whatToShow=2;
      }
  
getOtp()
{
  let url = this.app.baseUrl + 'getUserOtp';
  this.http.get(url).subscribe(
    (data: any) => {
      this.userOtp=data;
    }
  ,
  (error) => {
    console.error('HTTP Error:', error);
    window.alert('Otp not get');
  }
);
}

popOtp()
{
  window.alert('Your Otp is : '+this.userOtp);
}
      login() {
        let url = this.app.baseUrl + 'login/' + this.number;
      
        this.http.get(url).subscribe(
          (data: any) => {
            console.log('Backend response:', data);
            
            
      
            if (data === -1) {
              // The mobile number is not registered
              window.alert('Mobile number not registered.');
            } else if (data === 1) {
              // OTP sent successfully

              this.showOtp = 1;
              this.getOtp();
            } else {
              // Unexpected response from the backend
              window.alert('Unexpected response from the server.');
            }
          },
          (error) => {
            console.error('HTTP Error:', error);
            window.alert('An error occurred while connecting to the server.');
          }
        );
      }
      
    
      
    
      verifyOtp() {
        let url=this.app.baseUrl+'verifyOtp';
        let obj=[this.number,this.otp];
        this.http.post(url,obj).subscribe((data:any)=>
        {
          if(data==null || data==-1)
          {
            window.alert('Something is wrong')
          }
          else{
            this.showOtp=2;
            window.alert("login sucesssfully");
            this.senderMobile=this.number;   // Geting the mobile number of the sender
            this.getBankAccounts(); 
            this.app.whatToShow=3;
          }
        });
      }

        getBankAccounts()
        {
          let url = this.app.baseUrl+'getBankAccounts?mobile='+this.number;
          this.http.get(url).subscribe((data:any)=>
          {
            console.log("inLogin"+data);
            this.app.bankAccounts=data;

          });
        }
  
  
  }