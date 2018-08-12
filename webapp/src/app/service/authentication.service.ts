import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiService} from "./api.service";
import {catchError, map} from "rxjs/operators";
import {MessageService} from "./message.service";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private http: HttpClient, private api: ApiService, private messageService: MessageService) {

  }

  authenticate() {

  }

  async login(username: string, password: string): Promise<Object> {
    // TODO
    return Promise.resolve(undefined);
  }

  async register(username: string, password: string): Promise<Object> {
    const user: Object = {"username": username, "password": password};
    return this.http.post(this.api.usersApi, user).subscribe((r => this.login(username, password)));
  }

  isLoggedIn(): Promise<boolean> {
    // TODO: Check that the user is logged in...
    return Promise.resolve(false);
  }

  logout() {
    // TODO:implementation
  }
}
