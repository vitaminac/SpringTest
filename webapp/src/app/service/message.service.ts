import {BehaviorSubject} from "rxjs";
import {TranslationService} from "./translation.service";

export class MessageService {
  subject: BehaviorSubject<string>;

  constructor(private translation: TranslationService) {
    this.subject = new BehaviorSubject<string>(this.translation.Welcome);
  }

  add(message: string): void {
    this.subject.next(message);
  }

  clear() {
    // TODO:implementation
  }

  watch(watcher: (value: string) => void) {
    // show every message at least 1s
    this.subject.subscribe(watcher);
  }
}
