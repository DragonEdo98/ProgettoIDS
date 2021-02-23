import { Component } from '@angular/core';
import { CreamodelloaService } from './creamodelloa.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(private creaModelloAService: CreamodelloaService) {}

   creaModelloA() {
    var tipoEvento = (document.getElementById("AddTipoEvento") as HTMLInputElement).value;
    var luogoEvento = (document.getElementById("AddLuogoEvento") as HTMLInputElement).value;
    var volontario = (document.getElementById("AddVolontario") as HTMLInputElement).value;

    this.creaModelloAService.creaModelloA(tipoEvento, luogoEvento, "firma").subscribe(res => {
      if (res.codiceId) {
        alert("Modello A creato!");
      }
    }, error => {
      alert("Errore! Modello A non creato!");
    });
  }

 /* getInfoVolontario () {
    var volontario = (document.getElementById("AddVolontario") as HTMLInputElement).value;

  } */

}
