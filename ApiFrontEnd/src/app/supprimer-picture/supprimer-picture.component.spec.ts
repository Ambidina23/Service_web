import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerPictureComponent } from './supprimer-picture.component';

describe('SupprimerPictureComponent', () => {
  let component: SupprimerPictureComponent;
  let fixture: ComponentFixture<SupprimerPictureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerPictureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerPictureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
