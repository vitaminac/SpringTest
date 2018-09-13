import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AppConfig} from "../config/app.config";

@Injectable({
  providedIn: 'root'
})
export class UtilsService {
  constructor(private http: HttpClient) {
  }

  public convertFileToBase64(file: File, callback: (img: string) => void) {
    const reader = new FileReader();
    reader.addEventListener('load', () => callback(reader.result));
    reader.readAsDataURL(file);
  }

  public postForm(url, dto: any) {
    var headers = new HttpHeaders();
    headers.append(AppConfig.CONTENT_TYPE, AppConfig.FORM_DATA);
    return this.http.post(url, dto, {headers: headers})
  }
}
