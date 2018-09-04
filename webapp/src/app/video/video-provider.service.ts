import {Injectable} from '@angular/core';
import {VideoDTO} from "./videoDTO";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ApiService} from "../service/api.service";

@Injectable({
  providedIn: 'root'
})
export class VideoProviderService {

  constructor(private http: HttpClient, private api: ApiService) {
  }

  loadVideoList(): Observable<VideoDTO[]> {
    return this.http.get<VideoDTO[]>(this.api.VideoApi);
  }

  getVideo(id: number): Observable<VideoDTO> {
    return this.http.get<VideoDTO>(`${this.api.VideoApi}/${id}`);
  }
}
