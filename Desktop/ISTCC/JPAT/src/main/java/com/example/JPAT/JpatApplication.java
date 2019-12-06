package com.example.JPAT;

import java.sql.Date;
import java.text.SimpleDateFormat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class JpatApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaExampleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(JpatApplication.class, args);
	}

@Bean
public CommandLineRunner demo(VehiculeRepository repository) {
	return (args) -> {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2018-10-09");
		log.info(date.toString());

		Date date2 = dateFormat.parse("2018-10-12");
		log.info(date.toString());
		
		Vehicule peugeot = new Vehicule(456GH);
		Vehicule honda = new Vehicule(234ED);
		Person thibault = new Person("thibault",1);
		Person georges = new Person("georges",2);
		Rent rental2 = new Rent(date, date2, 2,honda, georges);
		Rent rental = new Rent(date, date2, 1, peugeot, thibault);

		peugeot.getRent().add(rental);
		honda.getRent().add(rental2);
				
		repository.save(peugeot);
		
		System.out.println("Vehicules found with findAll():");
		System.out.println("-------------------------------");
		for (Vehicule vehicule : repository.findAll()) {
			System.out.println(vehicule.toString());
		}
		System.out.println("");

		System.out.println("Vehicule found with findName('Peugeot'):");
		System.out.println("--------------------------------------------");
		
		
	
	};

}
}
