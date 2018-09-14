import {Component, OnInit} from '@angular/core';
import {VideoDto} from "../video.dto";
import {VideoProviderService} from "../video-provider.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit {
  videos$: Observable<VideoDto[]>;

  constructor(private provider: VideoProviderService) {
  }

  ngOnInit() {
    this.videos$ = this.provider.loadVideoList();
    // TODO css class [video-list, video-item]
    // TODO: video link to constant from component
  }
}
