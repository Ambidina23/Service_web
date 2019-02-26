import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierPictureComponent } from './modifier-picture.component';

describe('ModifierPictureComponent', () => {
  let component: ModifierPictureComponent;
  let fixture: ComponentFixture<ModifierPictureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifierPictureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifierPictureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
