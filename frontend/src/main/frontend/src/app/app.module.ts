import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http'

import { AppRoutingModule }     from './app-routing.module';

import { AppComponent } from './app.component';
import { HttpComponent } from "./http.component";
import { LibrariesComponent } from "./libraries.component";

@NgModule({
  declarations: [
    AppComponent,
    HttpComponent,
    LibrariesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
