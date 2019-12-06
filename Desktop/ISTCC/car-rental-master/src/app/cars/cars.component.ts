import { Component, OnInit } from '@angular/core';

import { Car } from '../car';
import { CarService } from '../car.service';


@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Car[];

  constructor(private carService: CarService) {
  }

  ngOnInit() {
   /* this.carService.getCars().then((cars) => this.cars = cars); */
    this.carService.getCarsWithObservable().subscribe(
      res => {
        this.cars = res;
      }
    );
  }

}
