import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../service/authentication.service";
import {Router} from "@angular/router";
import {AppConfig} from "../config/app.config";

@Component({
  selector: 'app-login-bar',
  templateUrl: './login-bar.component.html',
  styleUrls: ['./login-bar.component.css']
})
export class LoginBarComponent implements OnInit {

  // TODO: async pipe
  constructor(private auth: AuthenticationService, private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    this.auth.logout(() => this.router.navigate([AppConfig.LOGOUT]));
  }

  get authenticated(): boolean {
    return this.auth.authenticated;
  }
}
