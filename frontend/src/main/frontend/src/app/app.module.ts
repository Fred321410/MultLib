import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http'

import { AppRoutingModule }     from './app-routing.module';

import { AppComponent } from './app.component';
import { LibrariesComponent, LibraryDetailsComponent, NewLibraryFormComponent } from "./library/index";
import { LibrarySerivce, AuthenticationService, AlertService } from "./services/index";
import { PageNotFoundComponent, AlertComponent, ConfirmComponent } from "./directives/index";
import { LoginComponent, RegisterComponent } from './login/index';
import { PopoverModule } from 'ngx-popover';
import { BootstrapModalModule } from 'ng2-bootstrap-modal';
import {AuthGuard} from "./guards/index";


// used to create fake backend
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    LibrariesComponent,
    LibraryDetailsComponent,
    PageNotFoundComponent,
    ConfirmComponent,
    NewLibraryFormComponent,
    AlertComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    PopoverModule,
    BootstrapModalModule
  ],
  //Don't forget add component to entryComponents section
  entryComponents: [
    ConfirmComponent,
    NewLibraryFormComponent
  ],
  providers: [
    LibrarySerivce,
    AlertService,
    AuthenticationService,
    AuthGuard,
    MockBackend,
    BaseRequestOptions
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
