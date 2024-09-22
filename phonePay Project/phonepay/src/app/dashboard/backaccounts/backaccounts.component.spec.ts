import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BackaccountsComponent } from './backaccounts.component';

describe('BackaccountsComponent', () => {
  let component: BackaccountsComponent;
  let fixture: ComponentFixture<BackaccountsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BackaccountsComponent]
    });
    fixture = TestBed.createComponent(BackaccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
