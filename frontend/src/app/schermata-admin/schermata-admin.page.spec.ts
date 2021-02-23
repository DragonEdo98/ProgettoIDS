import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { SchermataAdminPage } from './schermata-admin.page';

describe('SchermataAdminPage', () => {
  let component: SchermataAdminPage;
  let fixture: ComponentFixture<SchermataAdminPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchermataAdminPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(SchermataAdminPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
