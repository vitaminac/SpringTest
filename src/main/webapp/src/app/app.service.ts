import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AppService {
  constructor(private http: HttpClient) {

  }

  switchLanguage(lan: string, callback) {
    this.http.get("?language=" + lan, {headers: {"X-Requested-With": "XMLHttpRequest"}}).subscribe(data => {
        return callback && callback(data);
      }
    );
  }
}
