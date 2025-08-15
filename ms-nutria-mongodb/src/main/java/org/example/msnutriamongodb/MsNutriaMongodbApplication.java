package org.example.msnutriamongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;

@SpringBootApplication (exclude = { MongoReactiveAutoConfiguration.class })
public class MsNutriaMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNutriaMongodbApplication.class, args);
	}

}
