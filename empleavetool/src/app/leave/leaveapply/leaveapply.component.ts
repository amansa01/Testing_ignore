import {Component} from '@angular/core';
import {FormControl, FormBuilder, Validators} from '@angular/forms';
import {LeaveModel} from '../leavemodel.interface';
import {LeaveApplyService} from './leaveapply.service';
import {Router} from '@angular/router';
import {LeaveTagComponent} from '../leavetag.component';
import {LoginService} from '../../login/login.service';
import {DetailsService} from '../../details.service';


@Component({
  selector: 'leave-apply',
  templateUrl: './leaveapply.component.html',
  styleUrls: ['./leaveapply.css']
})

export class LeaveApplyComponent {
  public selectedTag: LeaveTagComponent = new LeaveTagComponent(2, 'Sick');
  leavetag = [
    new LeaveTagComponent(1, 'Casual'),
    new LeaveTagComponent(2, 'Sick'),
    new LeaveTagComponent(3, 'Emergency'),
    new LeaveTagComponent(4, 'Home')
  ];

  public myForm = this._fb.group({
    fromDate: new FormControl(),
    reason: new FormControl('', <any>Validators.required),
    noDays: new FormControl(),
    leaveTag: new FormControl(Validators.maxLength(3)),
    toDate: new FormControl()
  });
  public userDetails: any;

  // tslint:disable-next-line:max-line-length
  constructor(private _fb: FormBuilder, private  leaveApplyService: LeaveApplyService, private router: Router, private loginService: LoginService, private detailsService: DetailsService) {
  }

  ngOnInit() {
    this.detailsService.getDetails().then((details) => {
      console.log(details);
      this.userDetails = details.empId;
    }).catch((error) => {
      console.log(error);
    });
  }


  save(model: LeaveModel) {
    console.log(model);
    model.empId = this.userDetails;
    this.leaveApplyService.leaveApply(model).then((Response) => {
      console.log(Response);
      alert(Response.text());
      this.router.navigate(['/mainpage']);
    }).catch((error) => {
      console.log(error);
    });

  }

  public onClickLogout() {
    this.loginService.sessionClear();
    console.log('Session Clear Called');
    window.sessionStorage.clear();
    this.router.navigate(['']);
  }

  public onClickHistory() {
    this.router.navigate(['/history']);
  }

  public onClickCancel() {
    this.router.navigate(['/cancel']);
  }
public onMainPage(){
    this.router.navigate(['/mainpage']);
}

}

