import { Component, Input } from '@angular/core';
import { Router } from '@angular/router'
import {Library} from "./library";
import {LibrarySerivce} from "./library.service";
import {PopoverModule} from "ngx-popover";

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
    private _router: Router
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
}
