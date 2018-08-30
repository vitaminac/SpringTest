import {Component, OnInit} from "@angular/core";
import {timer} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {AppConfig} from "../config/app.config";

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {
  errorCode: number;

  constructor(private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    // TODO: create errorCode -> to text pipe
    this.errorCode = this.route.snapshot.data.error;
    timer(AppConfig.REDIRECT_DELAY).subscribe(() => {
      this.router.navigate([""]);
    });
  }
}
