import { HttpBackend, HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-backaccounts',
  templateUrl: './backaccounts.component.html',
  styleUrls: ['./backaccounts.component.css']
})
export class BackaccountsComponent {
linkBankAccounts:any[]=[];
bankUserId:number=0;
  mobNumber: number=0;

  constructor (public app:AppComponent,private http:HttpClient)
  {
    this.getLinkAccounts();
  }



  linkAccount(bankUser: any)
  {
    let url=this.app.baseUrl+'LinkedAccountwithphonepay';
    this.bankUserId=bankUser.id;
    this.mobNumber=bankUser.mobile;
    this.http.post(url,bankUser).subscribe((data:any)=>{
      this.getLinkAccounts();
      // this.deleteFromBankUser()
console.log("linked");
console.log(data);
    });
  }


  getLinkAccounts()
        {

          let url = this.app.baseUrl+'getlinkbankaccounts?mobile='+this.mobNumber;
          this.http.get(url).subscribe((data:any)=>
          {
            console.log("inLogin"+data);
            this.linkBankAccounts=data;

          });
        }


//         deleteFromBankUser()
//         {
//           let url = `${this.app.baseUrl}deleteFromBankUser/${this.bankUserId}`;
//   this.http.delete(url).subscribe(
//     (data: any) => {
     
//       console.log('Account deleted successfully:', data);
//       this.getBankAccounts();
      

//     },
//     (error) => {
//       console.error('Error deleting account:', error);
//     }
//   );
// }


getBankAccounts()
{
  let url = this.app.baseUrl+'getBankAccounts?mobile='+this.mobNumber;
  this.http.get(url).subscribe((data:any)=>
  {
    console.log("inLogin"+data);
    this.app.bankAccounts=data;

  });
}

  get bankAccounts()
  {

    return this.app.bankAccounts;
  }
}


