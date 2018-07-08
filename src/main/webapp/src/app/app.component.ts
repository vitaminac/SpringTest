import {Component} from '@angular/core';
import {AppService} from "./app.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  welcome: string;
  messages = <any>{};
  language: string = "en";

  constructor(private  app: AppService) {
    // TODO: url from combo list
    // TODO: use angular i18n
    this.switchLanguage();
  }

  switchLanguage() {
    this.app.switchLanguage(this.language, (messages) => {
      this.messages = messages;
      this.welcome = messages["welcome"];
    });
  }
}
