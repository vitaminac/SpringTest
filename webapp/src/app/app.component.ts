import {Component, OnInit} from '@angular/core';
import {TranslationService} from "./service/translation.service";
import {Language} from "./languages/Language";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  language: Language = Language.English;
  languages = Language;
  keys: string[];

  constructor(private translator: TranslationService) {
    this.keys = Object.keys(this.languages).filter(k => !isNaN(Number(k)))
  }

  switchLanguage() {
    this.translator.switch(this.language);
  }

  ngOnInit(): void {
    // TODO: load current local language
    this.switchLanguage();
  }
}
