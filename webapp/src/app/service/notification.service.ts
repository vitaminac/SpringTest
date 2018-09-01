import {Observable, Subject} from "rxjs";
import {TranslationService} from "./translation.service";
import {Notification} from "../model/notification";
import {NotificationType} from "../model/notification.type";

export class NotificationService {
  private readonly _notifications: Subject<Notification> = new Subject();

  constructor(private translation: TranslationService) {
  }

  notify(notification: Notification): void {
    this._notifications.next(notification);
  }

  get notifications(): Observable<Notification> {
    // return an observable that can not publish event
    return this._notifications;
  }
}
