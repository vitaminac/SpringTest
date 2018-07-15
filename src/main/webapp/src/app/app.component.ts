import {Component} from '@angular/core';
import {TranslateService} from "./translate.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  language : string = "en";

  constructor(private translate: TranslateService) {
    // TODO: use angular i18n
    // TODO: work with bootstrap 3
  }

  async switchLanguage() {
    await this.translate.switch(this.language);
  }
}
