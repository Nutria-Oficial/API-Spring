package org.example.msnutriamongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication (exclude = { MongoReactiveAutoConfiguration.class })
@EnableMongoRepositories(basePackages = "org.example.msnutriamongodb.repository")
public class MsNutriaMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNutriaMongodbApplication.class, args);
	}
	

}