import {Component, OnDestroy, OnInit} from '@angular/core';
import {NotificationService} from "../service/notification.service";
import {delay, distinct, tap} from "rxjs/operators";
import {AppConfig} from "../config/app.config";
import {Subscription} from "rxjs";
import {Notification} from "../model/notification";
import {NotificationType} from "../model/notification.type";

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit, OnDestroy {
  // message: string;
  // private lastEmitTime: number = 0;
  private _subscription: Subscription;
  private notifications: Set<Notification> = new Set();

  constructor(private notificationService: NotificationService) {
  }

  close(notification: Notification) {
    this.notifications.delete(notification);
  }

  getType(type: number): string {
    return NotificationType[type];
  }

  ngOnInit(): void {
    this._subscription = this.notificationService.notifications.pipe(
      distinct(),
      // timestamp(),
      // flatMap((t: Timestamp<string>) => {
      //   const observable = of(t.value);
      //   const now = Date.now();
      //   if (now > this.lastEmitTime + AppConfig.TIME_SPAN_BETWEEN_NOTIFICATION_MILLISECOND) {
      //     this.lastEmitTime = now;
      //     return observable;
      //   } else {
      //     this.lastEmitTime += AppConfig.TIME_SPAN_BETWEEN_NOTIFICATION_MILLISECOND;
      //     return observable.pipe(delay(this.lastEmitTime - now));
      //   }
      // }),
      // tap(notification => this.message = notification),
      tap(notification => this.notifications.add(notification)),
      delay(AppConfig.NOTIFICATION_DISPLAY_SPAN_MILLISECOND)
      // debounceTime(AppConfig.NOTIFICATION_DISPLAY_SPAN_MILLISECOND)
    ).subscribe((value) => {
      // this.message = "";
      this.notifications.delete(value);
    });
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
