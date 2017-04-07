import { Component, Input } from '@angular/core';
import { Router } from '@angular/router'
import {Library} from "./library";
import {LibrarySerivce} from "./library.service";
import {PopoverModule} from "ngx-popover";
import { DialogService } from "ng2-bootstrap-modal";
import { ConfirmComponent } from '../confirm.component'


@Component({
  selector: 'library-details',
  templateUrl: './library.details.component.html',
  styleUrls: ['./library.details.component.css']
})
export class LibraryDetailsComponent {
  @Input()
  library: Library;


  constructor(
    private _libraryService: LibrarySerivce,
    private _router: Router,
    private dialogService:DialogService
  ) {}

  delete(){
    this._libraryService.delete(this.library)
      .subscribe(
        data => this.library = data,
        error => alert(error),
        () => window.location.reload()
      );
    window.location.reload();
  }

  edit(){
    this._libraryService.library = this.library;
    this._router.navigate(['/new-library']);
  }

  showConfirm() {
    this.dialogService.addDialog(ConfirmComponent, {
      title:'Confirmation',
      message:'Are you sure you want to delete the library: ' + this.library.libraryName + ' ?'})
      .subscribe((isConfirmed)=>{
        this.delete();
      });
  }
}
