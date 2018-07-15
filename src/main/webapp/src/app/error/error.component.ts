import {Component, OnInit} from "@angular/core";
import {timer} from "rxjs";
import {Router} from "@angular/router";
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {
  constructor(private router: Router) {

  }

  ngOnInit(): void {
    timer(environment.redirectWaitTime).subscribe(() => {
      this.router.navigate([""]);
    });
  }
}
