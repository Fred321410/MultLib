import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibrariesComponent }   from './library/index';
import { PageNotFoundComponent } from "./directives/index";
import { AuthGuard } from './guards/index';
import { LoginComponent, RegisterComponent } from './login/index';

const routes: Routes = [
  { path: '', redirectTo: '/libraries', pathMatch: 'full', canActivate: [AuthGuard] },
  { path: 'libraries',  component: LibrariesComponent, canActivate: [AuthGuard] },
  { path: 'login',  component: LoginComponent },
  { path: 'register',  component: RegisterComponent },
  { path: '**', component: PageNotFoundComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
