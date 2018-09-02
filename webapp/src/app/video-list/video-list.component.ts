import {Component, OnInit} from '@angular/core';
import {AppConfig} from "../config/app.config";
import {VideoDTO} from "../model/videoDTO";
import {VideoProviderService} from "../service/video-provider.service";

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit {
  videos: VideoDTO[];

  constructor(private provider: VideoProviderService) {
  }

  ngOnInit() {
    this.provider.loadVideoList().then((data) => this.videos = data);
    // TODO css class [video-list, video-item]
    // TODO: video link to constant from component
  }
}
