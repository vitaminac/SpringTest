import {Component, HostBinding, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {VideoProviderService} from "../video-provider.service";
import {DPlayerDanmaku, DPlayerVideo} from "dplayer";
import {Observable} from "rxjs";
import {map, switchMap} from "rxjs/operators";
import {VideoDto} from "../video.dto";
import {slideInDownAnimation} from "../../animations";

@Component({
  selector: 'app-video',
  templateUrl: './video-detail.component.html',
  styleUrls: ['./video-detail.component.css'],
  animations: [slideInDownAnimation]
})
export class VideoDetailComponent implements OnInit {
  @HostBinding('@routeAnimation') routeAnimation = true;
  @HostBinding('style.display') display = 'block';
  @HostBinding('style.position') position = 'absolute';

  dPlayerArguments$: Observable<DPlayerArguments>;

  constructor(private route: ActivatedRoute, private provider: VideoProviderService) {
  }

  ngOnInit() {
    this.dPlayerArguments$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => this.provider.getVideo(parseInt(params.get('id')))),
      map((video: VideoDto) => {
        return {
          dPlayerVideo: {
            url: video.uri,
            pic: video.cover,
            thumbnails: video.cover
          },
          danmaku: {
            id: '9E2E3368B56CDBB4',
            api: 'https://api.prprpr.me/dplayer3/'
          }
        }
      }));
  }
}

interface DPlayerArguments {
  dPlayerVideo: DPlayerVideo,
  danmaku: DPlayerDanmaku
}
