import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherPicturesComponent } from './afficher-pictures.component';

describe('AfficherPicturesComponent', () => {
  let component: AfficherPicturesComponent;
  let fixture: ComponentFixture<AfficherPicturesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficherPicturesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherPicturesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
