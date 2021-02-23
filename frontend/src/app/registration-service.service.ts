import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrganizzazioneVol } from './organizzazioneVol';

@Injectable({
  providedIn: 'root'
})
export class RegistrationServiceService {

  constructor(private httpClient: HttpClient) { }

  private registrazioneOrgUrl = `http://localhost:8100/nuovaRegistrazione`;
  private controlloCodiceRegistrazione = `http://localhost:8100/registrazione/{codiceVoloWebOrg}`;

  registrazioneOrg(organizzazioneVol: OrganizzazioneVol) : Observable<any> {
    return this.httpClient.post<OrganizzazioneVol> (this.registrazioneOrgUrl, organizzazioneVol);
  }

  controlloCodiceReg(organizzazioneVol: OrganizzazioneVol) : Observable<any> {
    return this.httpClient.post<OrganizzazioneVol> (this.controlloCodiceRegistrazione, organizzazioneVol);
  }


}
