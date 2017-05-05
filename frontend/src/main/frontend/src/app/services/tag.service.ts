import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Tag } from "../models/index";
import { AuthenticationService } from "./authentification.service";

@Injectable()
export class TagService{

  url = '/api/tag/';
  public tag : Tag;

  constructor (private _http: Http, private authentificationService: AuthenticationService) {}

  getTags(id: number) {
    return this._http.get(this.url + '?elementId=' + id, this.authentificationService.jwt())
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  getTagsByLib(id: number) {
    return this._http.get(this.url + '?libraryId=' + id, this.authentificationService.jwt())
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  getTag(id: number) : Observable<Tag>{

    return this._http.get(this.url + '?tagId=' + id, this.authentificationService.jwt())
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  create(tag: Tag): Observable<Tag> {
    let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + this.authentificationService.getToken()});
    let options = new RequestOptions({ headers: headers });


    return this._http.post(this.url, JSON.stringify(tag), options)
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }

  delete(tag: Tag): Observable<any>{
    let headers = new Headers({ 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + this.authentificationService.getToken()});
    let options = new RequestOptions({ headers: headers, body: JSON.stringify(tag) });

    return this._http.delete(this.url, options)
      .catch(this._errorHandler);
  }

  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || "Server Error")
  }


}
