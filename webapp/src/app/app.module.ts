import {BrowserModule} from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {TranslatePipe} from './pipe/translate.pipe';
import {FormsModule} from "@angular/forms";
import {HomeComponent} from './home/home.component';
import {NotificationComponent} from './notification/notification.component';
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {LibraryComponent} from "./library/library.component";
import {LoginComponent} from "./login/login.component";
import {ErrorComponent} from "./error/error.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {apiSetup} from "./config/api.setup";
import {ApiService} from "./service/api.service";
import {XhrInterceptor} from "./interceptor/xhr.interceptor";
import {ApiInterceptor} from "./interceptor/api.interceptor";
import {windowProvider} from "./config/window.provider";
import {WINDOW} from "./config/inject.token";
import {LoginBarComponent} from './login-bar/login-bar.component';
import {TranslationService} from "./service/translation.service";
import {NotificationService} from "./service/notification.service";
import {CredentialService} from "./service/credential.service";
import {AuthInterceptor} from "./interceptor/auth.interceptor";
import {ErrorInterceptor} from "./interceptor/error.interceptor";
import { TestComponent } from './test/test.component';


@NgModule({
  declarations: [
    AppComponent,
    NotificationComponent,
    LibraryComponent,
    LoginComponent,
    HomeComponent,
    ErrorComponent,
    TranslatePipe,
    LoginBarComponent,
    TestComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    windowProvider,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: XhrInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ApiInterceptor,
      multi: true,
      // Token that we want to inject into
      deps: [WINDOW]
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
      deps: [CredentialService]
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptor,
      multi: true
    },
    {
      provide: APP_INITIALIZER,
      useFactory: apiSetup,
      deps: [ApiService],
      multi: true
    },
    TranslationService,
    {
      provide: NotificationService,
      useClass: NotificationService,
      deps: [TranslationService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
