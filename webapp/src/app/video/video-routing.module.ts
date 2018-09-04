import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {VideoDetailComponent} from "./video-detail/video-detail.component";
import {AccessGuard} from "../app-routing/access.guard";
import {VideoListComponent} from "./video-list/video-list.component";

const videosRoutes: Routes = [
  {path: 'videos/:id', component: VideoDetailComponent, data: {requiresLogin: true}, canActivate: [AccessGuard]},
  {path: "videos", component: VideoListComponent, pathMatch: 'full', data: {requiresLogin: true}, canActivate: [AccessGuard]},
];

@NgModule({
  imports: [
    RouterModule.forChild(videosRoutes)
  ],
  exports: [RouterModule]
})
export class VideoRoutingModule {
}
