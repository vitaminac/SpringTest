import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {LibraryComponent} from "../library/library.component";
import {AccessGuard} from "./access.guard";
import {LoginComponent} from "../login/login.component";
import {ErrorComponent} from "../error/error.component";
import {HomeComponent} from "../home/home.component";
import {AppConfig} from "../config/app.config";
import {TestComponent} from "../test/test.component";

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {path: 'home', component: HomeComponent},
  {path: "library", component: LibraryComponent, data: {requiresLogin: true}, canActivate: [AccessGuard]},
  {path: AppConfig.LOGIN, component: LoginComponent},
  {path: "test", component: TestComponent},
  {path: '**', component: ErrorComponent, data: {error: AppConfig.NOT_FOUND}}
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
