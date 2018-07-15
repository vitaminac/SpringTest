import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router} from "@angular/router";
import {Observable} from "rxjs/index";
import {RouterStateSnapshot} from "@angular/router/src/router_state";
import {AuthService} from "../auth.service";

@Injectable()
export class AccessGuard implements CanActivate {

  constructor(private router: Router, private auth: AuthService) {
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
