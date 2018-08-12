import {Injectable, OnInit} from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  subject: BehaviorSubject<string>;

  constructor() {
    this.subject = new BehaviorSubject<string>("Welcome");
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
