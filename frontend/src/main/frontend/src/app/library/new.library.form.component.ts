import { Component } from '@angular/core';
import { DialogComponent, DialogService } from "ng2-bootstrap-modal";
import { Library } from "../models/index";

export interface NewLibModel {
  title:string;
  library:Library;
}

@Component({
  selector: 'new-lib-modal',
  templateUrl: './new.library.form.component.html',
  styleUrls: ['./new.library.form.component.css']
})
export class NewLibraryFormComponent extends DialogComponent<NewLibModel, boolean> implements NewLibModel {
  title: string;
  library: Library;
  constructor(dialogService: DialogService) {
    super(dialogService);
  }
  confirm() {
    // on click on confirm button we set dialog result as true,
    // ten we can get dialog result from caller code
    this.result = true;
    this.close();
  }
  cancel() {
    this.result = false;
    this.close();
  }
}
