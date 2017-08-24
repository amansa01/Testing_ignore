import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Http, Response} from '@angular/http';
import {map} from 'rxjs/operator/map';
@Injectable()
export class AuthGuard implements CanActivate{
  isvalidUser= false;
  result= false;
  constructor(private router: Router , private _http: Http) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    this._http.get('http://localhost:8080/empLeaveTool-1/emp/checkSession', {withCredentials: true })
      .map((response: Response) => response.json())
      .subscribe(
        data => this.isvalidUser = data,
        error => {},
        () => {
          if (this.isvalidUser === true) {
            this.result = true;
          }   else {
            this.router.navigate(['']);
            this.result = false;
          }
        }
      );
    return this.result;
  }
}
