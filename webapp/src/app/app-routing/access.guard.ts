import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router} from "@angular/router";
import {Observable} from "rxjs";
import {RouterStateSnapshot} from "@angular/router/src/router_state";
import {AuthenticationService} from "../service/authentication.service";
import {AppConfig} from "../config/app.config";

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
        if (this.auth.authenticated) {
          resolve(true);
        } else {
          this.router.navigate([AppConfig.LOGIN]);
          resolve(false);
        }
      })
    }
    return true;
  }
}
