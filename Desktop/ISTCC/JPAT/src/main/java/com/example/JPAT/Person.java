package com.example.JPAT;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Entity;

@Entity
public class Person {
	private String name ;
	private long id;
	private Collection<Rent> rent = new ArrayList<Rent>();
	
@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId(){
		return id;
	}

	public void setId(long id){

	}

@OneToMany(mappedBy ="Person")
	public Collection<Rent> getRent(){
		return rent;
	}
		
	public void setRent (Collection<Rent> rent) {
		this.rent = rent;
	}
	public Person(){
		super();
	}
	public Person(String name, long id){
		super();
		this.name= name;
		this.id = id;
	}

}
