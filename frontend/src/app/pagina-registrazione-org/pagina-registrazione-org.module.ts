import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PaginaRegistrazioneOrgPageRoutingModule } from './pagina-registrazione-org-routing.module';

import { PaginaRegistrazioneOrgPage } from './pagina-registrazione-org.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PaginaRegistrazioneOrgPageRoutingModule
  ],
  declarations: [PaginaRegistrazioneOrgPage]
})
export class PaginaRegistrazioneOrgPageModule {}
