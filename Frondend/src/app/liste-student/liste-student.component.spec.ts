import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeStudentComponent } from './liste-student.component';

describe('ListeStudentComponent', () => {
  let component: ListeStudentComponent;
  let fixture: ComponentFixture<ListeStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeStudentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
