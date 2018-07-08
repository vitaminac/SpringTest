import {Component} from '@angular/core';
import {AppService} from "./app.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  welcome: string;
  messages: Object = {};
  language: string = "en";

  constructor(private  app: AppService) {
    // TODO: use angular i18n
    // TODO: work with bootstrap 3
    this.switchLanguage();
  }

  switchLanguage() {
    this.app.switchLanguage(this.language).then((messages => {
      this.messages = messages;
      this.welcome = messages["welcome"];
    }));
  }
}
