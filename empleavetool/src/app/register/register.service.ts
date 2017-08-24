import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {Headers} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class RegisterService {

  constructor(private http: Http) {
  }

  signupValues(signupData: any) {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/empLeaveTool-1/emp/newemp', signupData, {withCredentials: true}).toPromise();
  }
}
