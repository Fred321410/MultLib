import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibrariesComponent }   from './library/libraries.component';
import { LoginComponent } from './login.component';
import {PageNotFoundComponent} from "./not-found.component";

const routes: Routes = [
  { path: '', redirectTo: '/libraries', pathMatch: 'full' },
  { path: 'libraries',  component: LibrariesComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', component: PageNotFoundComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
