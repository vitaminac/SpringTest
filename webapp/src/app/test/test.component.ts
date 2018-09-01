import {Component, OnInit} from '@angular/core';
import {NotificationService} from "../service/notification.service";
import {NotificationType} from "../model/notification.type";

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  comment: string;

  constructor(protected notification: NotificationService) {
  }

  ngOnInit() {
  }

  send() {
    this.notification.notify({type: NotificationType.info, message: this.comment});
  }
}
