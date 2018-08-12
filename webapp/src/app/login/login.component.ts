import {Component, OnInit} from "@angular/core";
import {AuthenticationService} from "../service/authentication.service";

enum Mode {
  CreateNew,
  Login
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  private _username: string;
  private _password: string;
  private mode: Mode = Mode.Login;

  constructor(private auth: AuthenticationService) {
  }

  ngOnInit() {
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

  loginOrRegister() {
    if (this.isLoginMode()) {
      this.auth.login(this.username, this.password);
    } else {
      this.auth.register(this.username, this.password);
    }
  }

  get password(): string {
    return this._password;
  }

  set password(password: string) {
    // TODO: hash
    this._password = password;
  }

  get username(): string {
    return this._username;
  }

  set username(username: string) {
    this._username = username;
  }
}
