import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Headers} from '@angular/http';
import {LeaveModel} from '../leavemodel.interface';

@Injectable()
export class LeaveCancelService {

  constructor(private http: Http) {
  }

  leaveCancel(empId: any) {
    event.preventDefault();
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/empLeaveTool-1/leave/history', empId,{ withCredentials: true}).toPromise();
    // return console.log(logindata);
  }

  onCancel(model: LeaveModel) {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/empLeaveTool-1/leave/cancel', model,{ withCredentials : true}).toPromise();

  }
}
