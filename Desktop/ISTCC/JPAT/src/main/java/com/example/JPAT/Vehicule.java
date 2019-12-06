package com.example.JPAT;

import java.util.Collection;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vehicule {

	protected long plateNumber;
	private Collection<Rent> rent = new ArrayList<Rent>();

	public Vehicule() {
		super();
	}

	public Vehicule (long plateNumber){
		super();
		this.plateNumber = plateNumber;
	}


@OneToMany(cascade=CascadeType.ALL, mappedBy ="vehicule")
public Collection <Rent> getRent() {
		return rent;
	}

	public void setRent(Collection <Rent> rent) {
		this.rent = rent;
	}

	@Id
	public long getPlateNumber(){
		return plateNumber;
	}

	public void setPlateNumber(long plateNumber){
		this.plateNumber = plateNumber;
	}
	
	
}
