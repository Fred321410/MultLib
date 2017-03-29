import { Component } from '@angular/core';
import {Library} from "./library";
import {LibrarySerivce} from "./library.service";

@Component({
  selector: 'new-library',
  templateUrl: './new.library.component.html',
  styleUrls: ['./new.library.component.css']
})
export class NewLibraryComponent {
  title = 'Create a new library';
  constructor(private _libraryService: LibrarySerivce) {}
  model = new Library('', '');
  library : Library;

  newLibrary(){
    this._libraryService.create(this.model)
      .subscribe(
        data => this.library = data,
        error => alert(error),
        () => console.log("Finished")
      );
    this.model = new Library('', '');
  }


}
