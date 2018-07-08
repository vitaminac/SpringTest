import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AppService {
  languages: Map<string, Object> = new Map<string, Object>();

  constructor(private http: HttpClient) {

  }

  switchLanguage(language: string, callback) {
    if (this.languages.get(language) == null) {
      this.http.get("?language=" + language, {headers: {"X-Requested-With": "XMLHttpRequest"}}).subscribe(data => {
          this.languages.set(language, data);
          return callback && callback(data);
        }
      );
    } else {
      return callback && callback(this.languages.get(language));
    }
  }
}
