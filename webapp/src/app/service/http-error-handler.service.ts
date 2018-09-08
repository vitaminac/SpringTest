import {Injectable} from '@angular/core';
import {Observable, throwError} from "rxjs";
import {HttpErrorResponse, HttpEvent} from "@angular/common/http";
import {CredentialService} from "./credential.service";
import {Location} from "@angular/common";
import {AppConfig} from "../config/app.config";

@Injectable({
  providedIn: 'root'
})
export class HttpErrorHandlerService {

  constructor(private credential: CredentialService) {
  }

  handle(err: HttpErrorResponse, caught: Observable<HttpEvent<any>>): Observable<HttpEvent<any>> {
    if (err.status && err.status == AppConfig.UNAUTHORIZED) {
      this.credential.invalidate();
      location.reload();
    }
    return throwError(err);
  }
}
