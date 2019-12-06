package com.example.JPAT;
@javax.persistence.Entity
@Entity
public class Car extends Vehicule{

	public Car(long plateNumber, int numberOfSeats) {
		super(plateNumber);
		this.numberOfSeats = numberOfSeats;
	}
	private int numberOfSeats ;

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Car() {
		super();
	}

}
