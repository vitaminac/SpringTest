import {Component, OnInit} from '@angular/core';
import {TranslationService} from "./service/translation.service";
import {Language} from "./languages/Language";
// TODO: optimize import
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
  }
}
