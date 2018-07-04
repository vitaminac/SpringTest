import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  welcome: string;
  language = <any>{};

  constructor(private  http: HttpClient) {
    // TODO: url from combo list
    http.get("?language=es", {headers: {"X-Requested-With": "XMLHttpRequest"}}).subscribe(data => {
        this.language = data;
        this.welcome = data["welcome"];
      }
    );
  }
}
