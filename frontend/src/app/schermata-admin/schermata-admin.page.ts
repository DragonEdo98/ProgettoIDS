import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-schermata-admin',
  templateUrl: './schermata-admin.page.html',
  styleUrls: ['./schermata-admin.page.scss'],
})
export class SchermataAdminPage implements OnInit {

  constructor(private router : Router) { }

  ngOnInit() {
  }

  nuovaRegistrazioneOrg() {
    return this.router.navigate(['/pagina-registrazione-org']);
  }
}