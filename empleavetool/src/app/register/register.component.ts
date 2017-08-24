import { Component } from '@angular/core';
import {RegisterService} from './register.service';
import {Router} from '@angular/router';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent  {
  response: any;
  gender: any;

  constructor(private registerService: RegisterService, private router: Router) {
    this.gender = {
      type: 'Male'
    };
  }



  onSubmit(value: any) {
    console.log(value);
    console.log('Submitted form');
    let signupData = {
      'empId': value.empid,
      'email': value.email,
      'passWord': value.password,
      'fName': value.fName,
      'lName': value.lName,
      'gender': value.type,
      'contactNo': value.contactNo,
      'empStatus': value.empStatus
    };
    console.log(signupData);
    this.registerService.signupValues(signupData).then((response) => {
      console.log(response.json());
      if (response.text() === 'false'){
      alert('Wrong Details Please Provide Correct Details'); } else {
        alert('Employee added');
      this.router.navigate(['']); }
    }).catch((error) => {
      console.log(error);

    }); }
    public onClickLogin() {
    this.router.navigate(['']);
  };
}
