import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfig} from "../config/app.config";
import {Inject} from "@angular/core";
import {WINDOW} from "../config/inject.token";

export class ApiInterceptor implements HttpInterceptor {
  constructor(@Inject(WINDOW) private window: Window) {

  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let url: URL;
    try {
      url = new URL(req.url);
    } catch (e) {
      url = new URL(req.url, this.window.location.href);
    }
    url.host = AppConfig.API_ENDPOINT_HOST;
    url.port = AppConfig.API_ENDPOINT_PORT.toString();
    url.protocol = AppConfig.API_ENDPOINT_PROTOCOL;
    if (url.pathname.startsWith("/")) {
      url.pathname = AppConfig.API + url.pathname;
    } else {
      url.pathname = AppConfig.API + "/" + url.pathname;
    }
    const api = req.clone({
      url: url.toString()
    });
    return next.handle(api);
  }
}
