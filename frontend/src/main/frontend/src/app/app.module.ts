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

@NgModule({
  declarations: [
    AppComponent,
    LibrariesComponent,
    LibraryDetailsComponent,
    NewLibraryComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    PopoverModule
  ],
  providers: [LibrarySerivce],
  bootstrap: [AppComponent]
})
export class AppModule { }
