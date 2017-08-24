
import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Headers} from '@angular/http';

@Injectable()
export class LeaveApplyService {

  constructor(private http: Http) {  }

  leaveApply(myForm: any) {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8080/empLeaveTool-1/leave/newleave', myForm, { withCredentials: true}).toPromise();

  }

}
