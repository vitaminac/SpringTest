import {Component, OnInit} from "@angular/core";
import {timer} from "rxjs";
import {Router} from "@angular/router";
import {AppConfig} from "../config/app.config";

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {
  constructor(private router: Router) {
  }

  ngOnInit(): void {
    timer(AppConfig.REDIRECT_DELAY).subscribe(() => {
      this.router.navigate([""]);
    });
  }
}
