package com.simplon.dvdstore.dvdstore;

import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepositoryInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class DvdstoreApplication {


	public static void main(String[] args) {
		SpringApplication.run(DvdstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DvdStoreRepositoryInterface repository) {
		return (args) -> {

			// save a few customers
			repository.save(new DvdModel("Jack", "Bauer"));
			repository.save(new DvdModel("Chloe", "O'Brian"));
			repository.save(new DvdModel("Kim", "Bauer"));
			repository.save(new DvdModel("David", "Palmer"));
			repository.save(new DvdModel("Michelle", "Dessler"));


		};
	}
}
