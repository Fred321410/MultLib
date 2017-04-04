import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {Library} from "./library";
import {LibrarySerivce} from "./library.service";
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'new-library',
  templateUrl: './new.library.component.html',
  styleUrls: ['./new.library.component.css']
})
export class NewLibraryComponent {
  title = 'Create a new library';
  constructor(
    private _libraryService: LibrarySerivce,
    private _router : Router
  ) {}
  library = new Library('','');

  ngOnInit() {
    if(this._libraryService.library) {
      this.library = this._libraryService.library;
    }
  }

  newLibrary(){
    this._libraryService.create(this.library)
      .subscribe(
        data => this.library = data,
        error => alert(error),
        () => this._router.navigate(['/libraries'])
      );
  }

  ngOnDestroy() {
    this.library = new Library('','');
    this._libraryService.library = new Library('','');
  }


}
