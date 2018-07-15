import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AuthService {
  constructor(private http: HttpClient) {

  }

  authenticate() {

  }

  async createNewUser(user) {
    return this.http.post("/user", user, {
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
