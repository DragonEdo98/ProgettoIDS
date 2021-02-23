import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PaginaRegistrazioneOrgPage } from './pagina-registrazione-org.page';

describe('PaginaRegistrazioneOrgPage', () => {
  let component: PaginaRegistrazioneOrgPage;
  let fixture: ComponentFixture<PaginaRegistrazioneOrgPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaRegistrazioneOrgPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PaginaRegistrazioneOrgPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
