import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AppConfig} from "../config/app.config";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UtilsService {
  private static FORM_HEADER = new HttpHeaders();

  static initialize() {
    this.FORM_HEADER.append(AppConfig.CONTENT_TYPE, AppConfig.FORM_DATA);
  }

  constructor(private http: HttpClient) {
  }

  public convertFileToBase64(file: File, callback: (content: string) => void) {
    const reader = new FileReader();
    reader.addEventListener('load', () => callback(reader.result));
    reader.readAsDataURL(file);
  }

  public postForm<T>(url, form: any, dto?: any): Observable<T> {
    // https://stackoverflow.com/a/25183266
    const formData = new FormData();
    Object.keys(form).forEach(key => formData.append(key, form[key]));
    formData.append("model", new Blob([JSON.stringify(dto)], {
      type: AppConfig.JSON
    }));
    return this.http.post<T>(url, formData, {headers: UtilsService.FORM_HEADER});
  }
}

UtilsService.initialize();
