import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GererPictureComponent } from './gerer-picture.component';

describe('GererPictureComponent', () => {
  let component: GererPictureComponent;
  let fixture: ComponentFixture<GererPictureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GererPictureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GererPictureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
