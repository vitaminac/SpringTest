import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {finalize} from "rxjs/operators";
import {CredentialDTO} from "../model/credentialDTO";
import {CredentialService} from "./credential.service";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private _authenticated: boolean;

  constructor(private http: HttpClient, private api: ApiService, private credential: CredentialService) {
    // TODO: initialize only once when goBack
    this.authenticate();
  }

  private authenticate(callback?: () => void): void {
    this.http.get(this.api.LoginApi).subscribe(response => {
      if (response['name']) {
        this._authenticated = true;
        this.credential.save();
      } else {
        this._authenticated = false;
        this.credential.clear();
      }
      // TODO: navigate back to previous
      return callback && callback();
    });
  }

  login(credential: CredentialDTO, callback?: () => void): void {
    this.credential.update(credential);
    this.authenticate(callback);
  }

  register(credential: CredentialDTO, callback?: () => void): void {
    // TODO: api url /api/register
    // TODO:credentials DTO
    this.http.post(this.api.RegisterApi, credential).subscribe(r => this.login(credential, callback));
  }

  get authenticated(): boolean {
    // TODO: Check that the user is logged in...
    return this._authenticated;
  }

  logout(callback?: () => void) {
    this.http.get(this.api.LogoutApi).pipe(finalize(() => {
      this._authenticated = false;
      return callback && callback();
    }));
  }
}
