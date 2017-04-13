import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Library } from "../models/index";
import { AuthenticationService } from "./authentification.service";

@Injectable()
export class LibrarySerivce{

  url = '/api/library/';
  public library : Library;

  constructor (private _http: Http, private authentificationService: AuthenticationService) {}

  getLibraries() {
    return this._http.get(this.url, this.authentificationService.jwt())
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  getLibrary(id: number) : Observable<Library>{

    return this._http.get(this.url + '?libraryId=' + id, this.authentificationService.jwt())
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  create(library: Library): Observable<Library> {
    let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + this.authentificationService.getToken()});
    let options = new RequestOptions({ headers: headers });


    return this._http.post(this.url, JSON.stringify(library), options)
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  delete(library: Library): Observable<any>{
    let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + this.authentificationService.getToken()});
    let options = new RequestOptions({ headers: headers, body: JSON.stringify(library) });

    return this._http.delete(this.url, options)
      .catch(this._errorHandler);
  }

  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || "Server Error")
  }


}
