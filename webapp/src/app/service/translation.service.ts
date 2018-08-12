import {Injectable} from '@angular/core';
import {Language} from "../languages/Language";
import {English} from "../languages/messages.en";
import {Spanish} from "../languages/messages.es";

@Injectable({
  providedIn: 'root'
})
export class TranslationService {
  private translation;

  constructor() {
  }

  switch(lang: Language): void {
    switch (lang) {
      case Language.English:
        this.translation = English;
        break;
      case Language.Spanish:
        this.translation = Spanish;
        break;
    }
  }

  translate(text: string): string {
    return this.translation[text] || text;
  }
}
