import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { map, filter, switchMap } from 'rxjs/operators';

import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl: string = 'http://localhost:8080/api';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  private user: User;
  constructor(private _http: Http) {
    
  }

  getUsers() {
      //   return this._http.get(this.baseUrl + '/users', this.options).map((response: Response) => response.json());
    return this._http.get(this.baseUrl + '/users', this.options).pipe(map((response: Response) => response.json()));
  }

  getUser(id: Number) {
    return this._http.get(this.baseUrl + '/user/' + id, this.options).pipe(map((response: Response) => response.json()));
  }

  deleteUser(id: Number) {
    return this._http.delete(this.baseUrl + '/user/' + id, this.options).pipe(map((response: Response) => response.json()));
  }

  createUser(user: User) {
    return this._http.post(this.baseUrl + '/user', JSON.stringify(user), this.options).pipe(map((response: Response) => response.json()));
  }

  updateUser(user: User) {
    return this._http.put(this.baseUrl + '/user', JSON.stringify(user), this.options).pipe(map((response: Response) => response.json()));
  }

  setter(user: User) {
    this.user = user;
  }

  getter() {
    return this.user;
  }
}
