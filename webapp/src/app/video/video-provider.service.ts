import {Injectable} from '@angular/core';
import {VideoDTO} from "./videoDTO";
import {HttpClient} from "@angular/common/http";
import {AppConfig} from "../config/app.config";

@Injectable({
  providedIn: 'root'
})
export class VideoProviderService {

  constructor(private http: HttpClient) {
  }

  async loadVideoList(): Promise<VideoDTO[]> {
    return this.http.get<VideoDTO[]>(AppConfig.VIDEOS).toPromise();
  }
}
