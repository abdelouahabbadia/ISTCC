import { Component, OnInit } from '@angular/core';
import { Car } from '../car';
import { CarService } from '../car.service';

@Component({
  selector: 'app-addvehicle',
  templateUrl: './addvehicle.component.html',
  styleUrls: ['./addvehicle.component.css']
})
export class AddvehicleComponent implements OnInit {

  car: Car = {
    brand: '',
    price: 0,
    plateNumber: ''
    };

  constructor(private carService: CarService) { }

  ngOnInit() {
  }
  create(car){
    console.log(car);
    this.carService.createCar(car);
  }

}
