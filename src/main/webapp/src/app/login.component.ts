import {Component} from "@angular/core";
import {LoginService} from "./login.service";

export enum Mode {
  CreateNew,
  Login
}

@Component({
  selector: 'app-root',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService]
})
export class LoginComponent {
  private username: string;
  private password: string;
  private mode: Mode = Mode.Login;

  constructor(private auth: LoginService) {

  }

  toggleMode() {
    if (this.isLoginMode()) {
      this.mode = Mode.CreateNew;
    } else {
      this.mode = Mode.Login;
    }
  }

  isLoginMode(): boolean {
    return this.mode == Mode.Login;
  }

  login() {
    if (this.isLoginMode()) {

    } else {
      this.auth.createNewUser({"username": this.username, "password": this.password});
    }
  }
}
