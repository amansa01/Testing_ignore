import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Headers} from '@angular/http';
import {Router} from "@angular/router";

@Injectable()
export class DetailsService {
  public userDetails: any;
  public response: any;
  session: any;
  empId:any;

  constructor(private http: Http) {
  }

  loginValues(loginData: any) {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');

    this.response = this.http.post('http://localhost:8080/empLeaveTool-1/emp/login', loginData, {withCredentials: true}).toPromise();
    return this.response;
  }
  sessionClear() {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.session = this.http.get('http://localhost:8080/empLeaveTool-1/emp/clearSession', { withCredentials: true}).toPromise();
    return this.session;
  }

  setDetails(userDetails: any) {
    this.userDetails = userDetails;
  }

  getDetails() {
    if (this.userDetails) {
      console.log(this.userDetails);
      return Promise.resolve(this.userDetails);
    } else {
      return Promise.reject('Not available');
    }
  }

  empDetails(empId:any)
  {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log('In Emp Details empId' + empId);
    this.http.post('http://localhost:8080/empLeaveTool-1/emp/details', empId, {withCredentials: true}).toPromise().then((response) => {
      console.log(response);
      this.userDetails = response.json();
    });
  }
}
