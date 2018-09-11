import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {VideoDetailComponent} from "./video-detail/video-detail.component";
import {VideoListComponent} from "./video-list/video-list.component";
import {VideoRoutingModule} from "./video-routing.module";
import {DPlayerModule} from "angular-dplayer";
import {VideoFormComponent} from "./video-form/video-form.component";
import {NgZorroAntdModule} from "ng-zorro-antd";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgZorroAntdModule,
    DPlayerModule,
    /** import ng-zorro-antd root module，you should import NgZorroAntdModule instead in sub module **/
    NgZorroAntdModule,
    VideoRoutingModule
  ],
  declarations: [
    VideoDetailComponent,
    VideoListComponent,
    VideoFormComponent
  ]
})
export class VideoModule {
}
