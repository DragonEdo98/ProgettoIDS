import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SchermataAdminPage } from './schermata-admin.page';

const routes: Routes = [
  {
    path: '',
    component: SchermataAdminPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SchermataAdminPageRoutingModule {}
