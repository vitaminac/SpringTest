import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {AppConfig} from "../config/app.config";

@Injectable()
export class ApiService {
  private api: Object;


  constructor(private http: HttpClient) {
  }

  get usersApi() {
    return this.api[AppConfig.USERS];
  }

  get LoginApi() {
    return this.api[AppConfig.LOGIN];
  }

  async load(): Promise<any> {
    return this.http.get<Object>("/").pipe(map((data) => this.api = data)).toPromise();
  }
}
