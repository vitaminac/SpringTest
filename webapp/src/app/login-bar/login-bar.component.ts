import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-login-bar',
  templateUrl: './login-bar.component.html',
  styleUrls: ['./login-bar.component.css']
})
export class LoginBarComponent implements OnInit {

  // TODO: async pipe
  constructor(private auth: AuthenticationService) {
  }

  ngOnInit() {
  }

  logout() {
    this.auth.logout();
  }

  get authenticated(): boolean {
    return this.auth.authenticated;
  }
}
