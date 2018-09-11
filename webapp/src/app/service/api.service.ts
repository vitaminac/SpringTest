import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {AppConfig} from "../config/app.config";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private api: Object;


  constructor(private http: HttpClient) {
  }

  get RegisterApi(): string {
    return this.api[AppConfig.REGISTER];
  }

  get usersApi() { // TODO: rename
    return this.api[AppConfig.USERS];
  }

  get LoginApi() {
    return this.api[AppConfig.LOGIN];
  }

  get LogoutApi() {
    return this.api[AppConfig.LOGOUT];
  }

  get VideoApi() {
    return this.api[AppConfig.VIDEOS];
  }

  get ImageApi(){
    return this.api[AppConfig.IMAGES];
  }

  async load(): Promise<any> {
    return this.http.get("/").pipe(map((data) => this.api = data)).toPromise();
  }
}
