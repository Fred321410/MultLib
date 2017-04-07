import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http'

import { AppRoutingModule }     from './app-routing.module';

import { AppComponent } from './app.component';
import { LibrariesComponent } from "./library/libraries.component";
import { NewLibraryComponent } from "./library/new.library.component"
import { LibrarySerivce } from "./library/library.service";
import { PageNotFoundComponent } from "./not-found.component";
import { LibraryDetailsComponent } from "./library/library.details.component";
import { PopoverModule } from 'ngx-popover';
import { BootstrapModalModule } from 'ng2-bootstrap-modal';
import { ConfirmComponent } from './confirm.component';

@NgModule({
  declarations: [
    AppComponent,
    LibrariesComponent,
    LibraryDetailsComponent,
    NewLibraryComponent,
    PageNotFoundComponent,
    ConfirmComponent
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
  ],
  providers: [LibrarySerivce],
  bootstrap: [AppComponent]
})
export class AppModule { }
