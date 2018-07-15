import {BrowserModule} from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {AuthService} from "./auth.service";
import {LibraryComponent} from './library/library.component';
import {AccessGuard} from "./guards/access.guard";
import {ErrorComponent} from './error/error.component';
import {TranslateService} from "./translate.service";
import {TranslatePipe} from './translate.pipe';

function setupTranslateFactory(service: TranslateService): Function {
  //TODO: detect local and switch
  return () => service.switch('en');
}

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
    ErrorComponent,
    TranslatePipe
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
  providers: [
    TranslateService,
    {
      provide: APP_INITIALIZER,
      useFactory: setupTranslateFactory,
      deps: [TranslateService],
      multi: true
    },
    AuthService,
    AccessGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
