import {Component, OnInit} from "@angular/core";
import {AuthenticationService} from "../service/authentication.service";
import {CredentialDTO} from "../model/credentialDTO";
import {Location} from '@angular/common';

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
  private credential: CredentialDTO = {username: "", password: ""};
  private mode: Mode = Mode.Login;

  constructor(private auth: AuthenticationService, private location: Location) {
  }

  ngOnInit() {
  }

  private goBack(): void {
    this.location.back();
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
      this.auth.login(this.credential, this.goBack.bind(this));
    } else {
      this.auth.register(this.credential, this.goBack.bind(this));
    }
  }

  get password(): string {
    return this.credential.password;
  }

  set password(password: string) {
    // TODO: hash
    this.credential.password = password;
  }

  get username(): string {
    return this.credential.username;
  }

  set username(username: string) {
    this.credential.username = username;
  }
}
