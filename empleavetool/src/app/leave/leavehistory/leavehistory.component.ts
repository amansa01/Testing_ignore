import {Component} from '@angular/core';
import {FormControl, FormBuilder, Validators} from '@angular/forms';

import {LeaveHistoryService} from './leavehistoryservice';
import {Router} from '@angular/router';
import {DetailsService} from '../../details.service';
import {LoginService} from '../../login/login.service';

@Component({
  selector: 'leave-apply',
  templateUrl: './leavehistory.html',
  styleUrls: ['./leavehistory.css']
})

export class LeaveHistoryComponent {
  Title = 'Aman';
  items: any;
  empId: any;
  details: any;
  private date: Date;
  public leaves: any[];

  public history = this._fb.group({
    empId: new FormControl('', [Validators.required, Validators.minLength(3)]),
  });
// tslint:disable-next-line:max-line-length
  constructor(private _fb: FormBuilder, private  leaveHistoryService: LeaveHistoryService, private router: Router, private loginService: LoginService
  , private detailsService: DetailsService ) {
    this.date = new Date();
  }

  ngOnInit() {
    this.detailsService.getDetails().then((details) => {
      this.details = details;
      console.log(this.details);
      this.empId = this.details.empId;
      }).catch((error) => {
         console.log(error);
      });
  }


  save() {
    console.log('value from login 1 ' + this.empId);
    this.leaveHistoryService.leaveHistory(this.empId).then((response) => {
      console.log((response.json()));
      console.log('value from login ' + this.details.empId);
      console.log(response.json().length);
      if (response.json().length > 0) {
        this.items = response.json();

      } else {
        alert('Employee Leave History Does Not Exist');
        this.router.navigate(['/mainpage']);
      }
    }).catch((error) => {
      console.log(error);
    });
  }

  public onClickLogout() {
   this.loginService.sessionClear();
   console.log('Session Clear Called');
    this.router.navigate(['']);
    window.sessionStorage.clear();
  }
  public onMainPage(){
    this.router.navigate(['/mainpage']);
  }

  public onClickHistory() {
    this.router.navigate(['/history']);
  }

  public onClickCancel() {
    this.router.navigate(['/cancel']);
  }

  public onClickApplyLeave() {
    this.router.navigate(['/leaveapply']);
  }
}
