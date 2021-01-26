import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ModelloA } from './modelloA';
import { User } from './user';

@Injectable({
  providedIn: 'root',
})
export class LoginServiceService {

  constructor(private httpClient: HttpClient) { }

  private accessoNormaleUrl = `http://localhost:8100/registrazione`;
  private accessoAdminUrl = `http://localhost:8100/accessoadmin`;

  login(user: User) : Observable<any> {
    return this.httpClient.post<User>(this.accessoNormaleUrl, user);
  }

  adminLogin(user: User) : Observable<any> {
    return this.httpClient.post<User>(this.accessoAdminUrl, user);
  }
}