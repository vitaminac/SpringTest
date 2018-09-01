import {Language} from "../languages/Language";
import {English} from "../languages/messages.en";
import {Spanish} from "../languages/messages.es";
import {Messages} from "../languages/messages";

export class TranslationService implements Messages { // TODO: rename Messages to Translation
  private translation: Messages;

  constructor() {
    this.translation = English;
  }

  // TODO: find design pattern
  get Welcome(): string {
    return this.translation.Welcome;
  }

  switch(lang: Language): void {
    // TODO: don't use new, register language in map when initialize
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
