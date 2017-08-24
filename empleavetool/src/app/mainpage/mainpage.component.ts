import {Component,  OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../login/login.service';
import {DetailsService} from '../details.service';

@Component({
  selector: 'main-page',
  templateUrl: './mainpage.html',
  styleUrls: ['./mainpage.css'],
  inputs: ['fName', 'lName', 'email:', 'contactNo', 'Gender']
})

export class MainPageComponent implements OnInit {

  public userDetails: any = {};
  // tslint:disable-next-line:max-line-length
  constructor(private router: Router, private loginService: LoginService, private loginservice: LoginService,
              private detailsService: DetailsService) {
  }

  ngOnInit() {
    console.log("Main Page NgOnInit");
    this.detailsService.getDetails().then((details) => {
      this.userDetails = details;
    }).catch((error) => {
      console.log(error);
    });
  }

  public onMainPage(){/*
    console.log('In Mainpage.component' + this.userDetails.empId);
    this.detailsService.empDetails(this.userDetails.empId).then((details:any) => {
      this.userDetails = details;
      console.log(this.userDetails.empId);
    }).catch((error:any) => {
      console.log(error);
    });*/
  }


  public onClickLogout() {
    this.loginService.sessionClear();
    this.router.navigate(['']);
    console.log('Session Clear Called');
    window.sessionStorage.clear();
  };

  public onClickApplyLeave() {
    this.router.navigate(['/leaveapply']);
  };

  public onClickHistory() {
    this.router.navigate(['/history']);
  };

  public onClickCancel() {
    this.router.navigate(['/cancel']);
  };
}
