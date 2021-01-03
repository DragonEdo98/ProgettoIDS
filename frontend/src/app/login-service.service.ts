import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ModelloA } from './modelloA';

@Injectable({
  providedIn: 'root',
})
export class LoginServiceService {

  constructor(private httpClient: HttpClient) { }

  private provaUrl = `http://localhost:8080/menu/1`;

  prova() : Observable<ModelloA> {
    return this.httpClient.get<ModelloA>(this.provaUrl);
  }
}