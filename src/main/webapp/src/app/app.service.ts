import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AppService {
  languages: Map<string, Object> = new Map<string, Object>();

  constructor(private http: HttpClient) {

  }

  async switchLanguage(language: string): Promise<Object> {
    if (this.languages.get(language) == null) {
      let data: Object = await this.http.get("?language=" + language, {headers: {"X-Requested-With": "XMLHttpRequest"}}).toPromise();
      this.languages.set(language, data);
    }
    return Promise.resolve(this.languages.get(language));
  }
}
