import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { FormVolontariComponent } from './form-volontari.component';

describe('FormVolontariComponent', () => {
  let component: FormVolontariComponent;
  let fixture: ComponentFixture<FormVolontariComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormVolontariComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(FormVolontariComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
