import { Component } from '@angular/core';
import { HttpSerivce } from "./http.service";

@Component({
  selector: 'http-test',
  template: `
  <button (click)="onTestGet()">Test Get Request</button><br>
    <p>Output: {{getData}}</p>
`,
  providers: [HttpSerivce]
})
export class HttpComponent {
  constructor(private _httpService: HttpSerivce) {}
  getData: string;

  onTestGet() {
    this._httpService.getTag().subscribe(
      data => this.getData = JSON.stringify(data),
      error => alert(error),
      () => console.log("Finished")
    );
  }
}


