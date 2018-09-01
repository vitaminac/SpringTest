import {Component, OnInit} from '@angular/core';
import {NotificationService} from "../service/notification.service";

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
    this.notification.notify(this.comment);
  }
}
