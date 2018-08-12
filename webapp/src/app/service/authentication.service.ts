import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ApiService} from "./api.service";
import {finalize} from "rxjs/operators";

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

  login(username: string, password: string, callback?: () => void): void {
    this.credentialsHeader = new HttpHeaders((username && password) ? {
      authorization: 'Basic ' + btoa(username + ':' + password)
    } : {});
    this.http.get('user', {headers: this.credentialsHeader}).subscribe(response => {
      if (response['name']) {
        this._authenticated = true;
      } else {
        this._authenticated = false;
      }
      // TODO: navigate back to previous
      return callback && callback();
    });
  }

  register(username: string, password: string, callback?: () => void): void {
    // TODO: api url /api/register
    // TODO:credentials DTO
    const user: Object = {"username": username, "password": password};
    this.http.post(this.api.usersApi, user).subscribe(r => this.login(username, password, callback));
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
