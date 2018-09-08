import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../service/authentication.service";
import {AppConfig} from "../config/app.config";
import {Language} from "../languages/Language";
import {TranslationService} from "../service/translation.service";

@Component({
  selector: 'app-header-bar',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  language: Language;
  languages = Language;
  keys: number[];

  constructor(private translator: TranslationService, private auth: AuthenticationService) {
    this.keys = Object.keys(this.languages).filter(k => !isNaN(Number(k))).map(i => parseInt(i));
  }

  switchLanguage() {
    this.translator.switch(this.language);
  }

  ngOnInit(): void {
    // TODO: load current local language
    this.language = Language.English;
    this.switchLanguage();
  }

  logout() {
    this.auth.logout(() => location.reload());
  }

  get authenticated(): boolean {
    return this.auth.authenticated;
  }

  get loginUrl(): string {
    return AppConfig.LOGIN;
  }
}
