import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ModelloA } from '../modelloA';

@Injectable({
  providedIn: 'root'
})
export class CreamodelloaService {

  constructor(private httpClient: HttpClient) { }

  private provaUrl = 'http://localhost:8080/menu';

  public creaModelloA(tipoEvento: string, luogoEvento: string, firmaResponsabileOrg: string): Observable<ModelloA> {
    const modelloA: ModelloA = {
      tipoEvento: tipoEvento,
      luogoEvento: luogoEvento,
      firmaResponsabileOrg: firmaResponsabileOrg
    }

    return this.httpClient.post<ModelloA>(this.provaUrl, modelloA);
  }
}
