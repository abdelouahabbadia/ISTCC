package com.example.JPAT;
import javax.persistence.Entity;
import com.example.JPAT.Vehicule;

@Entity
public class Van extends Vehicule{
	private int maxWeight ;

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public Van(long plateNumber, int maxWeight){
		super(plateNumber);
		this.maxWeight = maxWeight;
	}
	public Van() {
		super();
	}

}
