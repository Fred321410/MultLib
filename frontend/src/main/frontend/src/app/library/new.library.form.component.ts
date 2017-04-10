import { Component } from '@angular/core';
import { DialogComponent, DialogService } from "ng2-bootstrap-modal";
import {Library} from "./library";

export interface NewLibModel {
  title:string;
  library:Library;
}

@Component({
  selector: 'new-lib-modal',
  template: `<div class="modal-dialog">
                <div class="modal-content">
                   <div class="modal-header">
                        <button type="button" class="close" (click)="close()" >&times;</button>
                        <h4 class="modal-title">{{title || 'Create your own new library'}}</h4>
                   </div>
                   <div class="modal-body">
                     <form (ngSubmit)="onSubmit()" #libraryForm="ngForm">
                      <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" required
                               [(ngModel)]="this.library.libraryName" name="name"
                               #name="ngModel">
                        <div [hidden]="name.valid || name.pristine"
                             class="alert alert-danger">
                          Name is required
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control" rows="2" id="description"
                                  [(ngModel)]="library.libraryDescription" name="description"></textarea>
                      </div>
                    </form>
                   </div>
                    <div class="modal-footer">
                     <button type="button" class="btn btn-primary" (click)="confirm()">OK</button>
                     <button type="button" class="btn btn-default" (click)="cancel()">Cancel</button>
                   </div>
                 </div>
                </div>`
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
