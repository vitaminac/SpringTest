import {Component, OnDestroy, OnInit} from '@angular/core';
import {NotificationService} from "../service/notification.service";
import {debounceTime, delay, distinct, flatMap, tap, timestamp} from "rxjs/operators";
import {AppConfig} from "../config/app.config";
import {of, Subscription, Timestamp} from "rxjs";

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit, OnDestroy {
  message: string;
  private lastEmitTime: number = 0;
  private _subscription: Subscription;

  constructor(private notificationService: NotificationService) {
  }

  ngOnInit(): void {
    this._subscription = this.notificationService.notifications.pipe(
      distinct(),
      timestamp(),
      flatMap((t: Timestamp<string>) => {
        const observable = of(t.value);
        const now = Date.now();
        if (now > this.lastEmitTime + AppConfig.TIME_SPAN_BETWEEN_NOTIFICATION_MILLISECOND) {
          this.lastEmitTime = now;
          return observable;
        } else {
          this.lastEmitTime += AppConfig.TIME_SPAN_BETWEEN_NOTIFICATION_MILLISECOND;
          return observable.pipe(delay(this.lastEmitTime - now));
        }
      }),
      tap(notification => this.message = notification),
      debounceTime(AppConfig.NOTIFICATION_DISPLAY_SPAN_MILLISECOND)
    ).subscribe((value) => {
      this.message = "";
    });
  }

  ngOnDestroy(): void {
    this._subscription.unsubscribe();
  }
}
