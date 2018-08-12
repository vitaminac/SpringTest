import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-login-bar',
  templateUrl: './login-bar.component.html',
  styleUrls: ['./login-bar.component.css']
})
export class LoginBarComponent implements OnInit {

  constructor(private auth: AuthenticationService) {
  }

  ngOnInit() {
  }

  logout() {
    this.auth.logout();
  }

  isLoggedIn(): Promise<boolean> {
    return this.auth.isLoggedIn();
  }
}
