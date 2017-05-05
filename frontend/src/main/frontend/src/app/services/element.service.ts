import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Element } from "../models/index";
import { AuthenticationService } from "./authentification.service";

@Injectable()
export class ElementService{

  url = '/api/element/';
  public element : Element;

  constructor (private _http: Http, private authentificationService: AuthenticationService) {}

  getElements(id: number) {
    return this._http.get(this.url + '?libraryId=' + id, this.authentificationService.jwt())
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  getElement(id: number) : Observable<Element>{

    return this._http.get(this.url + '?elementId=' + id, this.authentificationService.jwt())
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  create(element: Element): Observable<Element> {
    let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + this.authentificationService.getToken()});
    let options = new RequestOptions({ headers: headers });


    return this._http.post(this.url, JSON.stringify(element), options)
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  delete(element: Element): Observable<any>{
    let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + this.authentificationService.getToken()});
    let options = new RequestOptions({ headers: headers, body: JSON.stringify(element) });

    return this._http.delete(this.url, options)
      .catch(this._errorHandler);
  }

  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || "Server Error")
  }


}
