import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfig} from "../config/app.config";
import {Inject} from "@angular/core";
import {WINDOW} from "../config/inject.token";

export class ApiInterceptor implements HttpInterceptor {
  constructor(@Inject(WINDOW) private window: Window) {

  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // if the url doesn't have base url then add api endpoint as base path
    try {
      new URL(req.url); // validate url
      return next.handle(req);
    } catch (e) {
      return next.handle(req.clone({
        url: AppConfig.API_ENDPOINT + (req.url.startsWith("/") ? req.url : "/" + req.url)
      }));
    }
  }
}
