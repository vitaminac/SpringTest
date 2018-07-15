import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {AppService} from "./app.service";
import {FormsModule} from "@angular/forms";
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {AuthService} from "./auth.service";
import {LibraryComponent} from './library/library.component';
import {AccessGuard} from "./guards/access.guard";
import {ErrorComponent} from './error/error.component';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'library',
    pathMatch: 'full'
  },
  {path: "library", component: LibraryComponent, data: {requiresLogin: true}, canActivate: [AccessGuard]},
  {path: "login", component: LoginComponent},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LibraryComponent,
    ErrorComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // TODO: <-- debugging purposes only
    ),
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AppService, AuthService, AccessGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
