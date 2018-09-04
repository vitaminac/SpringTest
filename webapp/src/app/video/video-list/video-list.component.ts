import {Component, OnInit} from '@angular/core';
import {VideoDTO} from "../videoDTO";
import {VideoProviderService} from "../video-provider.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit {
  videos$: Observable<VideoDTO[]>;

  constructor(private provider: VideoProviderService) {
  }

  ngOnInit() {
    this.videos$ = this.provider.loadVideoList();
    // TODO css class [video-list, video-item]
    // TODO: video link to constant from component
  }
}
