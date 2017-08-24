import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Headers} from '@angular/http';

@Injectable()
export class LoginService {
  loginData: any;
  session: any;
  constructor(private http: Http) {  }
  loginValues(loginData: any) {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
   this.loginData = this.http.post('http://localhost:8080/empLeaveTool-1/emp/login', loginData, {withCredentials: true}).toPromise();
   return this.loginData;
  }
  sessionClear() {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.session = this.http.get('http://localhost:8080/empLeaveTool-1/emp/clearSession', { withCredentials: true}).toPromise();
    return this.session;
  }
}
