import { Component } from '@angular/core';
import { LibrarySerivce, AlertService } from "../services/index";
import { DialogService } from "ng2-bootstrap-modal";
import { Library } from "../models/index";
import { NewLibraryFormComponent } from "./index";


@Component({
  selector: 'libraries',
  templateUrl: './libraries.component.html',
  styleUrls: ['./libraries.component.css']
})
export class LibrariesComponent {

  constructor(private _libraryService: LibrarySerivce,
              private dialogService: DialogService,
              private alertService: AlertService) {}
  libraries: Library[];
  selectedLibrary: Library;
  library: Library;

  onSelect(library: Library): void {
    this.selectedLibrary = library;
  }

  ngOnInit(){
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
          this.alertService.success('Your library has been created');
          this.library = new Library('','');
        }
      });
  }

  handleLibraryDeleted(libraryDeleted: Library){
    this.libraries = this.libraries.filter(function (el) {
      return el.libraryId != libraryDeleted.libraryId;
    })
    this.selectedLibrary = null;
    //this.getLibraries();
  }

  getLibraries(){
    this._libraryService.getLibraries().subscribe(
      data => this.libraries = data,
      error => this.alertService.error(error),
      () => console.log("Finished")
    );
  }

  newLibrary(){
    this._libraryService.create(this.library)
      .subscribe(
        data => this.libraries.push(data),
        error => this.alertService.error(error)
      );
  }

}
