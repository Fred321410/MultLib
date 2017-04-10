import { Component } from '@angular/core';
import {LibrarySerivce} from "./library.service";
import { AuthenticationService } from '../authentification.service';
import { DialogService } from "ng2-bootstrap-modal";
import {Library} from "./library";
import {NewLibraryFormComponent} from "./new.library.form.component";


@Component({
  selector: 'libraries',
  templateUrl: './libraries.component.html',
  styleUrls: ['./libraries.component.css']
})
export class LibrariesComponent {

  constructor(private _libraryService: LibrarySerivce,
              private dialogService:DialogService,
              private authervice:AuthenticationService) {}
  libraries: Library[];
  selectedLibrary: Library;
  library: Library;
  title = 'Your current Libraries';

  onSelect(library: Library): void {
    this.selectedLibrary = library;
  }

  ngOnInit(){
    this.authervice.checkCredentials();
    this.getLibraries();
    this.library = new Library('','');
  }

  new(){
    this.dialogService.addDialog(NewLibraryFormComponent, {
      title:'Creation of a new Library',
      library:this.library})
      .subscribe((isConfirmed = true)=>{
        if(isConfirmed){
          this.newLibrary();
          this.library = new Library('','');
        }
      });
  }

  handleLibraryDeleted(libraryDeleted: Library){
    this.libraries = this.libraries.filter(function (el) {
      return el.libraryId != libraryDeleted.libraryId;
    })
    //this.getLibraries();
  }

  getLibraries(){
    this._libraryService.getLibraries().subscribe(
      data => this.libraries = data,
      error => alert(error),
      () => console.log("Finished")
    );
  }

  newLibrary(){
    this._libraryService.create(this.library)
      .subscribe(
        data => this.libraries.push(data),
        error => alert(error)
      );
  }

}
