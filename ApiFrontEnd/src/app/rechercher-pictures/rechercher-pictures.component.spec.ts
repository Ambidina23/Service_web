import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherPicturesComponent } from './rechercher-pictures.component';

describe('RechercherPicturesComponent', () => {
  let component: RechercherPicturesComponent;
  let fixture: ComponentFixture<RechercherPicturesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherPicturesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherPicturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
