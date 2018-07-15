import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AuthService {
  constructor(private http: HttpClient) {

  }

  authenticate() {

  }

  async register(username, password) {
    const user: Object = {"username": username, "password": password};
    return this.http.post("/users", user, {
      headers: {
        "X-Requested-With": "XMLHttpRequest"
      }
    }).toPromise();
  }

  isLogon(): Promise<boolean> {
    // TODO: Check that the user is logged in...
    return Promise.resolve(false);
  }
}
