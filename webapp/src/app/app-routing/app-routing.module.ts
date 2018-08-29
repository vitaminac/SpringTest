import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {LibraryComponent} from "../library/library.component";
import {AccessGuard} from "../guard/access.guard";
import {LoginComponent} from "../login/login.component";
import {ErrorComponent} from "../error/error.component";
import {HomeComponent} from "../home/home.component";
import {AppConfig} from "../config/app.config";

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {path: 'home', component: HomeComponent},
  {path: "library", component: LibraryComponent, data: {requiresLogin: true}, canActivate: [AccessGuard]},
  {path: AppConfig.LOGIN, component: LoginComponent},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // TODO: <-- debugging purposes only
    )],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
