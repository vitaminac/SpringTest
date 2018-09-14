import {Injectable} from '@angular/core';
import {VideoDto} from "./video.dto";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ApiService} from "../service/api.service";

@Injectable({
  providedIn: 'root'
})
export class VideoProviderService {

  constructor(private http: HttpClient, private api: ApiService) {
  }

  loadVideoList(): Observable<VideoDto[]> {
    return this.http.get<VideoDto[]>(this.api.VideoApi);
  }

  getVideo(id: number): Observable<VideoDto> {
    return this.http.get<VideoDto>(`${this.api.VideoApi}/${id}`);
  }
}
