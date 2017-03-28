import { Component, Input } from '@angular/core';
import {Library} from "./library";

@Component({
  selector: 'library-details',
  templateUrl: './library.details.component.html',
  styleUrls: ['./library.details.component.css']
})
export class LibraryDetailsComponent {
  @Input()
  library: Library;
}
