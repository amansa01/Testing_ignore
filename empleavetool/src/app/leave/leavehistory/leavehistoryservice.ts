
import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import {Headers} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class LeaveHistoryService {

  constructor(private http: Http) {  }

  leaveHistory(empID: any) {
    event.preventDefault();
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log('In Service ' + empID);
    return this.http.post('http://localhost:8080/empLeaveTool-1/leave/history', empID, { withCredentials: true}).toPromise();
  }


}
