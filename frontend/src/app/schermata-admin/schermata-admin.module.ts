import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { SchermataAdminPageRoutingModule } from './schermata-admin-routing.module';

import { SchermataAdminPage } from './schermata-admin.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    SchermataAdminPageRoutingModule
  ],
  declarations: [SchermataAdminPage]
})
export class SchermataAdminPageModule {}
