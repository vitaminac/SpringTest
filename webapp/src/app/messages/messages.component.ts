import {Component, OnInit} from '@angular/core';
import {MessageService} from "../service/message.service";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {
  private _message: string;

  constructor(private messageService: MessageService) {
  }

  get message(): string {
    return this._message;
  }

  set message(value: string) {
    // TODO: disappear after 3s
    // TODO: if have multiples messages display the last and disappear after the last
    this._message = value;
  }

  ngOnInit() {
    this.messageService.watch((msg: string) => {
      this.message = msg;
    })
  }
}
