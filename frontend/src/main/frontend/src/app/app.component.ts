import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {AuthenticationService} from "./services/authentification.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MultLib';
  constructor(private authentificationService:AuthenticationService, private router:Router){}

  logout(){
    this.authentificationService.logout();
    this.router.navigate(['login']);
  }
}
