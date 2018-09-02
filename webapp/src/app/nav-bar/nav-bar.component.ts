import {Component, OnInit} from '@angular/core';
import {AppConfig} from "../config/app.config";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  constructor() {
  }

  ngOnInit() {
  }

  get videosUrl(): string {
    return AppConfig.VIDEOS;
  }
}
