import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {CredentialDTO} from "../model/credentialDTO";
import {CredentialService} from "./credential.service";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private _authenticated: boolean;

  constructor(private http: HttpClient, private api: ApiService, private credential: CredentialService) {
    if (this.credential.hasCredential()) {
      this._authenticated = true;
    } else {
      this._authenticated = false;
    }
  }

  private authenticate(callback?: () => void): void { // TODO: infinite loop
    this.http.get(this.api.LoginApi).subscribe(response => {
      if (response['name']) {
        this._authenticated = true;
        this.credential.save();
      } else {
        this._authenticated = false;
        this.credential.invalidate();
      }
      return callback && callback();
    });
  }

  login(credential: CredentialDTO, callback?: () => void): void {
    this.credential.update(credential);
    this.authenticate(callback);
  }

  register(credential: CredentialDTO, callback?: () => void): void {
    this.http.post(this.api.RegisterApi, credential).subscribe(r => this.login(credential, callback));
  }

  get authenticated(): boolean {
    return this._authenticated;
  }

  logout(callback?: () => void) {
    this.http.get(this.api.LogoutApi).subscribe(() => {
      this._authenticated = false;
      this.credential.invalidate();
      return callback && callback();
    });
  }
}
