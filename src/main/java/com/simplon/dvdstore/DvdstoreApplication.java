package com.simplon.dvdstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DvdstoreApplication {

//Le controlleur : il sert à recevoir les données Json et à les passer au service (map en Service Model)
//Le service: il sert à recevoir les données en Service Model , effectuer des traitements et les passer au repository (map en RepositoryModel
//Le Repository: il sert à recevoir les données en RepositoryModel et requeter la base de données

	public static void main(String[] args) {
		SpringApplication.run(DvdstoreApplication.class, args);
	}


}
