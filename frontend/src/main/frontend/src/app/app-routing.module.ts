import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibrariesComponent }   from './libraries.component';
import { NewLibraryComponent } from './new.library.component';
import {PageNotFoundComponent} from "./not-found.component";

const routes: Routes = [
  { path: '', redirectTo: '/libraries', pathMatch: 'full' },
  { path: 'libraries',  component: LibrariesComponent },
  { path: 'new-library',  component: NewLibraryComponent },
  { path: '**', component: PageNotFoundComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
