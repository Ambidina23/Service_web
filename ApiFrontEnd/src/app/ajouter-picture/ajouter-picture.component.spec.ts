import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterPictureComponent } from './ajouter-picture.component';

describe('AjouterPictureComponent', () => {
  let component: AjouterPictureComponent;
  let fixture: ComponentFixture<AjouterPictureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterPictureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterPictureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
