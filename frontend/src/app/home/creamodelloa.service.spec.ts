import { TestBed } from '@angular/core/testing';

import { CreamodelloaService } from './creamodelloa.service';

describe('CreamodelloaService', () => {
  let service: CreamodelloaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreamodelloaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
