import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }  from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarsComponent } from './cars/cars.component';
import { CarDetailComponent } from './car-detail/car-detail.component';
import { AddvehicleComponent } from './addvehicle/addvehicle.component';

@NgModule({
  declarations: [
    AppComponent,
    CarsComponent,
    CarDetailComponent,
    AddvehicleComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
