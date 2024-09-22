import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  constructor (public http:HttpClient, public app:AppComponent)
  {

  }

  showOtp:number=0;
  number:number=0;
  otp:number=0;
  pin:number=0;
  pin2:number=0;

  register()
  {
    let url=this.app.baseUrl+'register'+this.number;
    
    
      this.http.get(url).subscribe((data:any)=>
      {
        if(data==null || data==-1)
        {
          window.alert("something went wrong");
        }
        else
        {
          this.showOtp=1;
        }
      })

  }

 
  verify()
  {
    let url=this.app.baseUrl+'verifyOtp';
    let obj=[this.number,this.otp];
      this.http.post(url,obj).subscribe((data:any)=>
      {
        if(data==null || data==-1)
        {
          window.alert("something went wrong");
        }
        else
        {
          this.showOtp=2;
        }
      })
  }

  set()
  {
    if(this.pin==this.pin2)
    {
      let url=this.app.baseUrl+'setPin'+this.number;
      this.http.post(url,this.pin).subscribe((data:any)=>
      {
        if(data==null || data==-1)
        {
          window.alert("something went wrong");
        }
        else
        {
          this.app.whatToShow=3;
        }
      })

    }
    else
    {
      window.alert("pin is not match")
    }
  }

}



