import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibrariesComponent }   from './libraries.component';

const routes: Routes = [
  { path: '', redirectTo: '/libraries', pathMatch: 'full' },
  { path: 'libraries',  component: LibrariesComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
