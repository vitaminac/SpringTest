import {Component, OnInit} from '@angular/core';
import {TranslationService} from "./service/translation.service";
import {Language} from "./languages/Language";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  language: Language;
  languages = Language;
  keys: number[];

  constructor(private translator: TranslationService) {
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
}
