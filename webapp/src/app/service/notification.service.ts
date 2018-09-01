import {Observable, Subject} from "rxjs";
import {TranslationService} from "./translation.service";

export class NotificationService {
  private readonly _notifications: Subject<string> = new Subject();

  constructor(private translation: TranslationService) {
  }

  notify(message: string): void {
    this._notifications.next(message);
  }

  get notifications(): Observable<string> {
    // return an observable that can not publish event
    return this._notifications;
  }
}
