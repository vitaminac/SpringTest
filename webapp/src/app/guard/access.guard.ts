import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router} from "@angular/router";
import {Observable} from "rxjs";
import {RouterStateSnapshot} from "@angular/router/src/router_state";
import {AuthenticationService} from "../service/authentication.service";

@Injectable({
  providedIn: 'root'
})
export class AccessGuard implements CanActivate {

  constructor(private router: Router, private auth: AuthenticationService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    const requiresLogin: boolean = route.data.requiresLogin || false;
    if (requiresLogin) {
      return new Promise((resolve, reject) => {
        this.auth.isLogon().then((answer: boolean) => {
          if (answer) {
            resolve(true);
          } else {
            this.router.navigate(["/login"]);
            resolve(false);
          }
        }, (reason) => {
          reject(reason);
        });
      });
    }
    return true;
  }
}
