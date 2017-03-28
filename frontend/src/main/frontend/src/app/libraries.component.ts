import { Component } from '@angular/core';
import {LibrarySerivce} from "./library.service";
import {Library} from "./library";

@Component({
  selector: 'libraries',
  templateUrl: './libraries.component.html',
  styleUrls: ['./libraries.component.css']
})
export class LibrariesComponent {

  constructor(private _libraryService: LibrarySerivce) {}
  libraries: Library[];
  selectedLibrary: Library;
  title = 'Your current Libraries';

  onSelect(library: Library): void {
    this.selectedLibrary = library;
  }

  ngOnInit(){
    this._libraryService.getLibraries().subscribe(
      data => this.libraries = data,
      error => alert(error),
      () => console.log("Finished")
    );
  }

}
