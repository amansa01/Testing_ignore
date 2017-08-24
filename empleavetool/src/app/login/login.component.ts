import {Component} from '@angular/core';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
import {DetailsService} from "../details.service";


@Component({
  selector: 'Login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  styles: [`input.ng-invalid {
    border-left: 5px solid red;
  }

  input.ng-valid {
    border-left: 5px solid green;
  }`]
})
export class LoginComponent {

  response: any;
  public loginData1: any;
  public gotResponse: any;

  constructor(private router: Router,
              private detailsService: DetailsService) {
  }

  onSubmit(value: any) {
    console.log(value);
    let loginData = {
      'email': value.email,
      'passWord': value.password,
    };
    console.log(loginData);
    this.detailsService.loginValues(loginData).then((response: any) => {
      console.log(response.json());
      if (response.json()) {
        this.loginData1 = response.json();
        this.detailsService.setDetails(response.json());
        console.log('In Login Component ' + this.loginData1.empId);
        this.router.navigate(['/mainpage']);
      } else {
        alert('Wrong Email or Password');
      }
    }).catch((error: any) => {
      return console.log(error);
    });
  }
}
