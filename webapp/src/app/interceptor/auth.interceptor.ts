import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {CredentialService} from "../service/credential.service";

export class AuthInterceptor implements HttpInterceptor {
  constructor(private manager: CredentialService) {// @Inject(forwardRef(() => CredentialService)) private manager: CredentialService) { TODO: circular reference, how to solve
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.manager.hasCredential()) {
      const auth = req.clone({
        headers: req.headers.set('Authorization', this.manager.credential)
      });
      return next.handle(auth);
    } else {
      return next.handle(req);
    }
  }
}
