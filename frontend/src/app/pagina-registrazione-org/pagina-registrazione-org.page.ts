import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrganizzazioneVol } from '../organizzazioneVol';
import { RegistrationServiceService } from '../registration-service.service';

@Component({
  selector: 'app-pagina-registrazione-org',
  templateUrl: './pagina-registrazione-org.page.html',
  styleUrls: ['./pagina-registrazione-org.page.scss'],
})
export class PaginaRegistrazioneOrgPage implements OnInit {

  constructor(private registrationService: RegistrationServiceService, private router: Router) { }

  ngOnInit() {
  }

  registrazioneOrg() {
    var nomeOrg = (document.getElementById("AddNomeOrg") as HTMLInputElement).value;
    var codiceVoloWeb = parseInt((document.getElementById("AddCodiceVoloWeb") as HTMLInputElement).value);
    var passwordVoloWeb = (document.getElementById("AddPassword") as HTMLInputElement).value;
    var IdcoordinatoreOrg = parseInt((document.getElementById("AddIDCoordinatore") as HTMLInputElement).value);
    var nomeCoordinatore = (document.getElementById("AddNomeCoordinatore") as HTMLInputElement).value;
    var cognomeCoordinatore = (document.getElementById("AddCognomeCoordinatore") as HTMLInputElement).value;

    this.registrationService.registrazioneOrg(new OrganizzazioneVol(nomeOrg, codiceVoloWeb, passwordVoloWeb, IdcoordinatoreOrg, nomeCoordinatore, cognomeCoordinatore)).subscribe (
      data => {
        console.log("registrazione effettuata");
      },

      error => {
        console.log(error);
      }
    )

  } 
}
