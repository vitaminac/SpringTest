import {BrowserModule} from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {TranslatePipe} from './pipe/translate.pipe';
import {FormsModule} from "@angular/forms";
import {HomeComponent} from './home/home.component';
import {NotificationComponent} from './notification/notification.component';
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {LoginComponent} from "./login/login.component";
import {ErrorComponent} from "./error/error.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {apiSetup} from "./config/api.setup";
import {ApiService} from "./service/api.service";
import {XhrInterceptor} from "./interceptor/xhr.interceptor";
import {ApiInterceptor} from "./interceptor/api.interceptor";
import {windowProvider} from "./config/window.provider";
import {WINDOW} from "./config/inject.token";
import {HeaderComponent} from './header/header.component';
import {TranslationService} from "./service/translation.service";
import {NotificationService} from "./service/notification.service";
import {CredentialService} from "./service/credential.service";
import {AuthInterceptor} from "./interceptor/auth.interceptor";
import {ErrorInterceptor} from "./interceptor/error.interceptor";
import {TestComponent} from './test/test.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {NavBarComponent} from './nav-bar/nav-bar.component';
import {VideoModule} from "./video/video.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {en_US, NZ_I18N} from "ng-zorro-antd";
/** config angular i18n **/
import {registerLocaleData} from '@angular/common';
import en from '@angular/common/locales/en';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    NotificationComponent,
    LoginComponent,
    HomeComponent,
    ErrorComponent,
    TranslatePipe,
    HeaderComponent,
    TestComponent,
    NavBarComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgbModule,
    VideoModule,
    // AppRoutingModule is last
    // The order of route configuration matters. The router accepts the first route that matches a navigation request path.
    AppRoutingModule
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
    TranslationService, // TODO: try to remove it
    {
      provide: NotificationService,
      useClass: NotificationService,
      deps: [TranslationService]
    },
    /** config ng-zorro-antd i18n **/
    { provide: NZ_I18N, useValue: en_US }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
