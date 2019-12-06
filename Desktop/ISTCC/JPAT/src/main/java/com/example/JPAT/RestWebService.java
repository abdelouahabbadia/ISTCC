package com.example.JPATest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {

	VehiculeRepository vehiculeRepository;
	
	@Autowired
	public RestWebService(VehiculeRepository vehiculeRepository) {
		super();
		this.vehiculeRepository = vehiculeRepository;
	}
	
	@GetMapping("/vehicules")
	public Iterable<Vehicule> getVehicules(){
		return vehiculeRepository.findAll();
	}
}
	