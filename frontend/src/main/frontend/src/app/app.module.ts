import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http'

import { AppRoutingModule }     from './app-routing.module';

import { AppComponent } from './app.component';
import { LibrariesComponent } from "./libraries.component";
import { NewLibraryComponent } from "./new.library.component"
import {LibrarySerivce} from "./library.service";
import {PageNotFoundComponent} from "./not-found.component";

@NgModule({
  declarations: [
    AppComponent,
    LibrariesComponent,
    NewLibraryComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [LibrarySerivce],
  bootstrap: [AppComponent]
})
export class AppModule { }
