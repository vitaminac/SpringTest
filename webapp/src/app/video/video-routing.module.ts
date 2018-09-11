import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {VideoDetailComponent} from "./video-detail/video-detail.component";
import {AccessGuard} from "../app-routing/access.guard";
import {VideoListComponent} from "./video-list/video-list.component";
import {VideoFormComponent} from "./video-form/video-form.component";

const videosRoutes: Routes = [
  {
    // https://stackoverflow.com/a/43487962
    path: 'videos', data: {requiresLogin: true}, canActivate: [AccessGuard], children: [
      {path: 'new', component: VideoFormComponent,},
      {path: ':id', component: VideoDetailComponent},
      {path: "", component: VideoListComponent, pathMatch: 'full'},
    ]
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(videosRoutes)
  ],
  exports: [RouterModule]
})
export class VideoRoutingModule {
}
