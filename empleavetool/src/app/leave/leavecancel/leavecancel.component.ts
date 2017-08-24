import {Component} from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {LeaveCancelService} from './leavecancelservice';
import {LeaveModel} from '../leavemodel.interface';
import {LoginService} from '../../login/login.service';
import {DetailsService} from '../../details.service';


@Component({
  selector: 'leave-apply',
  templateUrl: './leavecancel.html',
  styleUrls: ['./leavecancel.css']
})


export class LeaveCancelComponent {
  leaveDetails: any;
  index = 0;
  empId: any;
  details: any;
  public leaves: any[];
  public cancel = this._fb.group({
    empId: new FormControl('', [Validators.required, Validators.minLength(3)]),
  });

  // tslint:disable-next-line:max-line-length
  constructor(private _fb: FormBuilder, private  leaveCancelService: LeaveCancelService, private router: Router, private loginService: LoginService, private detailsService: DetailsService) {
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
    console.log();
    this.leaveCancelService.leaveCancel(this.empId).then((response) => {
      console.log((response.json()));
      this.leaves = response.json();
      console.log(response.json().length);
      if (response.json().length > 0) {
        this.leaveDetails = response.json();

      } else {
        alert('Employee Leave History Does Not Exist');
        this.router.navigate(['/mainpage']);
      }
    }).catch((error) => {
      console.log(error);
    });
  }

  onCancel(value: LeaveModel) {
    this.leaveCancelService.leaveCancel(value).then((response) => {
      console.log(response);
    }).catch((error) => {
      console.log(error);
    });


    this.leaveCancelService.onCancel(value).then((response) => {
      alert((response.text()));

      console.log(this.details.leaveBalance);
      this.detailsService.empDetails(this.details.empId);

    });
  }
  public onMainPage(){
    this.router.navigate(['/mainpage']);
  }
  public onClickLogout() {
    this.loginService.sessionClear();
    console.log('Session Clear Called');
    this.router.navigate(['']);
    window.sessionStorage.clear();
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


