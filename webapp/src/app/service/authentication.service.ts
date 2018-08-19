import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ApiService} from "./api.service";
import {finalize} from "rxjs/operators";
import {CredentialDTO} from "../model/credentialDTO";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService implements OnInit {
  private credentialsHeader;
  private _authenticated = false;

  constructor(private http: HttpClient, private api: ApiService) {

  }

  authenticate() {

  }

  login(credential: CredentialDTO, callback?: () => void): void {
    this.credentialsHeader = new HttpHeaders((credential) ? {
      authorization: 'Basic ' + btoa(credential.username + ':' + credential.password)
    } : {});
    this.http.get(this.api.usersApi, {headers: this.credentialsHeader}).subscribe(response => {
      if (response['name']) {
        this._authenticated = true;
      } else {
        this._authenticated = false;
      }
      // TODO: navigate back to previous
      return callback && callback();
    });
  }

  register(credential: CredentialDTO, callback?: () => void): void {
    // TODO: api url /api/register
    // TODO:credentials DTO
    this.http.post(this.api.usersApi, credential).subscribe(r => this.login(credential, callback));
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

  ngOnInit(): void {
    // check if is login at started
  }
}
