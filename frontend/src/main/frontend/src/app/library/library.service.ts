import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Library} from "./library";

@Injectable()
export class LibrarySerivce{

  url = '/api/library/';

  constructor (private _http: Http) {}

  getLibraries() {
    return this._http.get(this.url + 'get')
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  create(library: Library): Observable<Library> {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    return this._http.post(this.url + 'add', JSON.stringify(library), options)
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || "Server Error")
  }

}
