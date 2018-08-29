import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {catchError} from "rxjs/operators";
import {AppConfig} from "../config/app.config";
import {Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {CredentialService} from "../service/credential.service";

@Injectable({
  providedIn: "root"
})
export class ErrorInterceptor implements HttpInterceptor {
  // TODO: goto Login page there is authentication error
  constructor(private credential: CredentialService, private router: Router) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(catchError((err: HttpErrorResponse) => {
      if (err.status && err.status == AppConfig.UNAUTHORIZED) {
        this.credential.invalidate();
        this.router.navigate([AppConfig.LOGIN]); // TODO: the page doesn't render correctly
      }
      return throwError(err);
    }));
  }
}
