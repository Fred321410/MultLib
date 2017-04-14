import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {User} from "../models/user";

@Injectable()
export class UserService{
  public user : User;

  constructor (private _http: Http) {}

  create(user: User): Observable<User> {
    let headers = new Headers({ 'Content-Type': 'application/json'});
    let options = new RequestOptions({ headers: headers });


    return this._http.post('api/registration', JSON.stringify(user), options)
      .map((response:Response) => response.json())
      .catch(this._errorHandler);
  }


  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || "Server Error")
  }


}
