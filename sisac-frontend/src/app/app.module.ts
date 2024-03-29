import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthGuard } from './shared';
import { LanguageTranslationModule } from './shared/modules/language-translation/language-translation.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FilterComboPipe } from './shared/pipes/filter-combo.pipe';
import { JwtModule } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import { ServerErrorsInterceptor } from './shared/util/server-errors.interceptor';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';

export function tokenGetter() {
  let tk = JSON.parse(sessionStorage.getItem(environment.TOKEN_NAME));
  let token = tk != null ? tk.access_token : '';
  return token;
}

@NgModule({
  declarations: [
    AppComponent,
    FilterComboPipe
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    LanguageTranslationModule,
    AppRoutingModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        whitelistedDomains: ['172.21.3.71'],  //'localhost:8080'
        blacklistedRoutes: ['http://172.21.3.71/oauth/token']
      }
    })
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ServerErrorsInterceptor,
      multi: true,
    },
    { provide: LocationStrategy, useClass: HashLocationStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
