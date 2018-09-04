import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Observable} from "rxjs";
import {VideoDTO} from "../videoDTO";
import {switchMap} from "rxjs/operators";
import {VideoProviderService} from "../video-provider.service";

@Component({
  selector: 'app-video',
  templateUrl: './video-detail.component.html',
  styleUrls: ['./video-detail.component.css']
})
export class VideoDetailComponent implements OnInit {
  video$: Observable<VideoDTO>; // TODO get object from id
  constructor(private route: ActivatedRoute, private provider: VideoProviderService) {
  }

  ngOnInit() {
    this.video$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) =>
        this.provider.getVideo(parseInt(params.get('id'))))
    );
  }
}
