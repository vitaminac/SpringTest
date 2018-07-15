import {Component, OnInit} from "@angular/core";
import {AuthService} from "../auth.service";

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

  constructor(private auth: AuthService) {
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
      // TODO: implement
    } else {
      this.auth.register({"username": this._username, "password": this._password});
    }
  }

  get password():string{
    return this._password;
  }

  set password(password:string){
    // TODO: hash
    this._password=password;
  }

  get username():string{
    return this._username;
  }

  set username(username:string){
    this._username = username;
  }
}
