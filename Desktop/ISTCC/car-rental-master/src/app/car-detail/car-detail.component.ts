import { switchMap } from 'rxjs/operators';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { CarService } from '../car.service';
import { Car } from '../car';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css']
})
export class CarDetailComponent implements OnInit {

  car: Car;

  constructor(
    private carService: CarService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    /*this.route.paramMap.pipe(
      switchMap((params: ParamMap) =>
        this.carService.getCar(params.get('plateNumber')))
    ).subscribe(car => this.car = car);*/
    this.route.paramMap.pipe(
          switchMap((params: ParamMap) =>
            this.carService.getCarWithObservable(params.get('plateNumber')))
        ).subscribe(car => this.car = car);
  }

}
