import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PaginaRegistrazioneOrgPage } from './pagina-registrazione-org.page';

const routes: Routes = [
  {
    path: '',
    component: PaginaRegistrazioneOrgPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PaginaRegistrazioneOrgPageRoutingModule {}
