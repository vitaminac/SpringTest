import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {VideoDetailComponent} from "./video-detail/video-detail.component";
import {VideoListComponent} from "./video-list/video-list.component";
import {VideoRoutingModule} from "./video-routing.module";
import {DPlayerModule} from "angular-dplayer";


@NgModule({
  imports: [
    CommonModule,
    DPlayerModule,
    VideoRoutingModule
  ],
  declarations: [
    VideoDetailComponent,
    VideoListComponent
  ]
})
export class VideoModule {
}
