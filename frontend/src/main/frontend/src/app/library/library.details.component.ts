import { Component, Input, Output, EventEmitter  } from '@angular/core';
import {Library, Element} from "../models/index";
import {LibrarySerivce} from "../services/index";
import { DialogService } from "ng2-bootstrap-modal";
import { ConfirmComponent } from '../directives/confirm.component'
import { NewLibraryFormComponent } from './index';


@Component({
  selector: 'library-details',
  templateUrl: './library.details.component.html',
  styleUrls: ['./library.details.component.css']
})
export class LibraryDetailsComponent {
  @Input()
  library: Library;
  selectedElement: Element;
  idsElementsToExpend: number[];

  @Output() libraryDeleted = new EventEmitter();


  constructor(
    private _libraryService: LibrarySerivce,
    private dialogService:DialogService
  ) {}

  ngOnInit(){
    this.idsElementsToExpend = [];
  }

  onElementSelect(element: Element): void {
    this.selectedElement = element;
  }

  onDblElementSelect(element: Element): void{
    let index = this.idsElementsToExpend.indexOf(element.elementId, 0);
    if (index > -1) {
      this.idsElementsToExpend.splice(index, 1);
    } else {
      this.idsElementsToExpend.push(element.elementId);
    }
  }

  delete(){
    this._libraryService.delete(this.library)
      .subscribe(
        data => console.log(data),
        error => alert(error),
        () => this.libraryDeleted.emit(this.library)
      );
  }

/*  edit(){
    this._libraryService.library = this.library;
    this._router.navigate(['/new-library']);
  }*/

  edit(){
    this._libraryService.library = Object.assign({}, this.library);
    this.dialogService.addDialog(NewLibraryFormComponent, {
      title:'Edit of the Library: ',
      library:this.library})
      .subscribe((isConfirmed = true)=>{
        if(isConfirmed){
          this.newLibrary();
        } else {
          this.library = Object.assign({}, this._libraryService.library );

        }
      });
  }

  newLibrary(){
    this._libraryService.create(this.library)
      .subscribe(
        data => this.library = data,
        error => alert(error)
      );
  }

  showConfirm() {
    this.dialogService.addDialog(ConfirmComponent, {
      title:'Confirmation',
      message:'Are you sure you want to delete the library: ' + this.library.libraryName + ' ?'})
      .subscribe((isConfirmed)=>{
        if(isConfirmed){
          this.delete();
        }
      });
  }
}
