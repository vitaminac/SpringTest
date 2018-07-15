import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class TranslateService {
  private languages: Map<string, Object> = new Map<string, Object>();
  private translated: Object;

  constructor(private http: HttpClient) {
  }

  async switch(lang: string) {
    if (this.languages.get(lang) == null) {
      let data: Object = await this.http.get("?language=" + lang, {headers: {"X-Requested-With": "XMLHttpRequest"}}).toPromise();
      this.languages.set(lang, data);
    }
    this.translated = this.languages.get(lang);
  }

  getTranslatedText() {
    return this.translated;
  }
}
